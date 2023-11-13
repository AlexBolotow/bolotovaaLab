package tech.reliab.course.bolotovaa.bank;

import tech.reliab.course.bolotovaa.bank.entity.*;
import tech.reliab.course.bolotovaa.bank.service.*;
import tech.reliab.course.bolotovaa.bank.service.impl.*;
import tech.reliab.course.bolotovaa.bank.utils.RegexPatterns;
import tech.reliab.course.bolotovaa.bank.utils.generators.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        BankATMService bankAtmService = new BankATMServiceImpl();
        UserService userService = new UserServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();

        List<Bank> banks = new ArrayList<>();
        List<String> banksNames = new ArrayList<>();
        Collections.addAll(banksNames, "UniCredit", "Sberbank", "Tinkoff", "VTB", "Gazprombank");

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(userService.createUser(RandomUserGenerator.getRandomUser(i)));
        }

        //создаем банки
        for (int i = 0; i < 5; i++) {
            Bank bank = bankService.createBank(new Bank(i, banksNames.get(i)));

            List<BankOffice> bankOffices = new ArrayList<>();

            //создаем офисы
            for (int j = 0; j < 3; j++) {
                BankOffice bankOffice = bankOfficeService.
                        createBankOffice(new BankOffice(RandomBankOfficeGenerator.getRandomBankOffice(j)));

                List<Employee> employees = new ArrayList<>();

                //создаем сотрудников
                for (int k = 0; k < 5; k++) {
                    Employee employee = employeeService.createEmployee(RandomEmployeeGenerator.getRandomEmployee(k + j * 5));
                    employeeService.updateBankOffice(employee, bankOffice);
                    employees.add(employee);
                }

                bankOffices.add(bankOffice);
                bankService.addEmployees(bank, employees);
            }

            List<BankATM> bankATMs = new ArrayList<>();

            //создаем банкоматы
            for (int j = 0; j < 3; j++) {
                Random random = new Random();
                int indexOffice = random.nextInt(bankOffices.size());
                BankATM bankATM = bankAtmService.
                        createBankAtm(new BankATM(RandomBankATMGenerator.getRandomBankATM(j, bank,
                                bankOffices.get(indexOffice))));

                //создаем обслуживающего сотрудника
                Employee employee = employeeService.createEmployee(RandomEmployeeGenerator.getRandomServiceEmployee(5 * j));
                bankAtmService.updateServiceEmployee(bankATM, employee);

                List<BankATM> bankOfficeATMS = new ArrayList<>();
                bankOfficeATMS.add(bankATM);
                bankOfficeService.addBankATM(bankOffices.get(indexOffice), bankOfficeATMS);
                bankATMs.add(bankATM);
            }

            List<User> bankUsers = new ArrayList<>();

            //добавляем клиентов
            for (int j = 0; j < 5; j++) {
                User user = users.get(j);

                List<Bank> userBanks = new ArrayList<>();
                userBanks.add(bank);
                userService.addBanks(user, userBanks);

                //создаем платежные и кредитные счета клиента
                for (int k = 0; k < 2; k++) {
                    List<PaymentAccount> paymentAccounts = new ArrayList<>();
                    List<CreditAccount> creditAccounts = new ArrayList<>();
                    PaymentAccount paymentAccount = paymentAccountService
                            .createPaymentAccount(RandomPaymentAccountGenerator.getRandomPaymentAccount(k + i * 2, user, bank));
                    paymentAccounts.add(paymentAccount);
                    userService.addPaymentAccounts(user, paymentAccounts);
                    CreditAccount creditAccount = creditAccountService
                            .createCreditAccount(RandomCreditAccountGenerator.getRandomCreditAccount(k + i * 2, user, bank));
                    creditAccounts.add(creditAccount);
                    userService.addCreditAccounts(user, creditAccounts);
                }

                bankUsers.add(user);
            }

            bankService.addBankOffices(bank, bankOffices);
            bankService.addBankATMS(bank, bankATMs);
            bankService.addUsers(bank, bankUsers);

            banks.add(bank);
        }


        Scanner scanner = new Scanner(System.in);
        String control = "c";
        while (control.equals("c")) {
            System.out.println("Information about bank or user?");
            System.out.println("Enter: \n b - bank \n u - user \n q - quit");
            control = scanner.nextLine();

            if (control.equals("b")) {
                System.out.println("--------------------------------------------------------");
                System.out.println("Banks (bank id - bank name):");
                banks.forEach(x -> System.out.println(x.getId() + " - " + x.getName()));
                System.out.println("--------------------------------------------------------");
                System.out.println("Enter: bank id or \n c - continue \n q - quit");

                control = scanner.nextLine();
                boolean isId = control.matches(RegexPatterns.ID);

                if (isId) {
                    int id = Integer.parseInt(control);
                    System.out.println("--------------------------------------------------------");
                    Bank bank = banks.get(id);
                    System.out.println(bank);
                    System.out.println("--------------------------------------------------------");

                    System.out.println("""
                            Enter:\s
                             o - bank offices\s
                             a - bank ATMs\s
                             e - bank employees\s
                             u - bank users\s
                             c - continue\s
                             q - quit""");

                    control = scanner.nextLine();

                    switch (control) {
                        case "o" -> {
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Bank offices (office id - office name):");
                            bank.getBankOffices().forEach(x -> System.out.println(x.getId() + " - " + x.getName()));
                            do {
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter: office id or \n c - continue \n q - quit");

                                control = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                isId = control.matches(RegexPatterns.ID);
                                if (isId) {
                                    id = Integer.parseInt(control);
                                    System.out.println(bank.getBankOffices().get(id));
                                }
                            } while (!control.equals("c") && !control.equals("q"));
                        }

                        case "a" -> {
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Bank ATMs (ATM id - ATM name):");
                            bank.getBankATMS().forEach(x -> System.out.println(x.getId() + " - " + x.getName()));
                            do {
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter: ATM id or \n c - continue \n q - quit");

                                control = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                isId = control.matches(RegexPatterns.ID);
                                if (isId) {
                                    id = Integer.parseInt(control);
                                    System.out.println(bank.getBankATMS().get(id));
                                }
                            } while (!control.equals("c") && !control.equals("q"));
                        }

                        case "e" -> {
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Bank employees (employee id - employee full name):");
                            bank.getEmployees().forEach(x -> System.out.println(x.getId() + " - " + x.getFullName()));
                            do {
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter: employee id or \n c - continue \n q - quit");

                                control = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                isId = control.matches(RegexPatterns.ID);
                                if (isId) {
                                    id = Integer.parseInt(control);
                                    System.out.println(bank.getEmployees().get(id));
                                }
                            } while (!control.equals("c") && !control.equals("q"));
                        }

                        case "u" -> {
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Bank users (user id - user full name):");
                            bank.getUsers().forEach(x -> System.out.println(x.getId() + " - " + x.getFullName()));
                            do {
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter: user id or \n c - continue \n q - quit");

                                control = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                isId = control.matches(RegexPatterns.ID);
                                if (isId) {
                                    id = Integer.parseInt(control);
                                    System.out.println(bank.getUsers().get(id));
                                }
                            } while (!control.equals("c") && !control.equals("q"));
                        }
                    }
                }
            } else if (control.equals("u")) {
                System.out.println("--------------------------------------------------------");
                System.out.println("Users (user id - user full name):");
                users.forEach(x -> System.out.println(x.getId() + " - " + x.getFullName()));
                System.out.println("--------------------------------------------------------");

                System.out.println("Enter: user id or \n c - continue \n q - quit");

                control = scanner.nextLine();
                boolean isId = control.matches(RegexPatterns.ID);

                if (isId) {
                    int id = Integer.parseInt(control);
                    System.out.println("--------------------------------------------------------");
                    int finalId = id;
                    User user = users.stream().filter(x -> x.getId() == finalId).findFirst().get();
                    System.out.println(user);
                    System.out.println("--------------------------------------------------------");

                    System.out.println("""
                            Enter:\s
                             b - user banks\s
                             p - user payment accounts\s
                             k - user credit accounts\s
                             c - continue\s
                             q - quit""");

                    control = scanner.nextLine();

                    switch (control) {
                        case "b" -> {
                            System.out.println("--------------------------------------------------------");
                            System.out.println("User banks:");
                            user.getBanks().forEach(x -> System.out.println(x.getName()));
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Enter: \n c - continue \n q - quit");

                            control = scanner.nextLine();
                            System.out.println("--------------------------------------------------------");
                        }

                        case "p" -> {
                            System.out.println("--------------------------------------------------------");
                            System.out.println("User payment accounts (account id - bank name):");
                            user.getPaymentAccounts().forEach(x -> System.out.println(x.getId() + " - " +
                                    x.getBank().getName()));
                            do {
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter payment account id or \n c - continue \n q - quit");

                                control = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                isId = control.matches(RegexPatterns.ID);
                                if (isId) {
                                    id = Integer.parseInt(control);
                                    System.out.println(user.getPaymentAccounts().get(id));
                                }
                            } while (!control.equals("c") && !control.equals("q"));
                        }

                        case "k" -> {
                            System.out.println("--------------------------------------------------------");
                            System.out.println("User credit accounts (account id - bank name):");
                            user.getCreditAccounts().forEach(x -> System.out.println(x.getId() + " - " +
                                    x.getBank().getName()));
                            do {
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter credit account id or \n c - continue \n q - quit");

                                control = scanner.nextLine();
                                System.out.println("--------------------------------------------------------");
                                isId = control.matches(RegexPatterns.ID);
                                if (isId) {
                                    id = Integer.parseInt(control);
                                    System.out.println(user.getCreditAccounts().get(id));
                                }
                            } while (!control.equals("c") && !control.equals("q"));
                        }
                    }
                }
            }
        }
    }
}
