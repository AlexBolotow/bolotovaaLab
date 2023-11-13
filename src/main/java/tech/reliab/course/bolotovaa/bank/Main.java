package tech.reliab.course.bolotovaa.bank;

import tech.reliab.course.bolotovaa.bank.entity.*;
import tech.reliab.course.bolotovaa.bank.enums.BankATMStatus;
import tech.reliab.course.bolotovaa.bank.enums.BankOfficeStatus;
import tech.reliab.course.bolotovaa.bank.service.*;
import tech.reliab.course.bolotovaa.bank.service.impl.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.createBank(new Bank("UniCredit"));

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        BankOffice bankOffice = bankOfficeService.createBankOffice(new BankOffice("Main",
                "Via Giuseppe Verdi, 7", BankOfficeStatus.WORK, true, 5, true,
                true, true, BigDecimal.valueOf(900000), BigDecimal.valueOf(50000)));

        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.createEmployee(new Employee("Andrea Pirlo",
                LocalDate.of(1979, 5, 19), "Service employee",
                bank, false, bankOffice, true, BigDecimal.valueOf(5000)));

        BankATMService bankAtmService = new BankATMServiceImpl();
        BankATM bankAtm = bankAtmService.createBankAtm(new BankATM("First", "Via Giuseppe Verdi, 7",
                BankATMStatus.WORK, bank, bankOffice, employee, true, true,
                BigDecimal.valueOf(24000), BigDecimal.valueOf(2500)));

        ArrayList<Bank> banks = new ArrayList<>();
        banks.add(bank);

        UserService userService = new UserServiceImpl();
        User user = userService.createUser(new User("Steph Curry",
                LocalDate.of(1988, 3, 14), "NBA", banks));

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(
                new PaymentAccount(user, bank, BigDecimal.valueOf(15000)));

        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        CreditAccount creditAccount = creditAccountService.createCreditAccount(new CreditAccount(user, bank,
                LocalDate.of(2023, 10, 29), LocalDate.of(2024, 4, 29),
                6, BigDecimal.valueOf(100000), BigDecimal.valueOf(18500), employee,
                paymentAccount));

        System.out.println(bank);
        System.out.println("===========================");
        System.out.println(bankOffice);
        System.out.println("===========================");
        System.out.println(employee);
        System.out.println("===========================");
        System.out.println(bankAtm);
        System.out.println("===========================");
        System.out.println(user);
        System.out.println("===========================");
        System.out.println(paymentAccount);
        System.out.println("===========================");
        System.out.println(creditAccount);
    }
}
