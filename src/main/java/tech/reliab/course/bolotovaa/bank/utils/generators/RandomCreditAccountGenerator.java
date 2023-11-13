package tech.reliab.course.bolotovaa.bank.utils.generators;

import tech.reliab.course.bolotovaa.bank.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

public class RandomCreditAccountGenerator {
    public static CreditAccount getRandomCreditAccount(long id, User user, Bank bank) {
        Random random = new Random();
        LocalDate startDate = RandomDateGenerator.getRandomDate(user.getBirthday().plusDays(6570),
                LocalDate.now());
        LocalDate finishDate = RandomDateGenerator.getRandomDate(LocalDate.now().plusDays(1),
                LocalDate.now().plusYears(30));
        long countMonth = Period.between(startDate, finishDate).getMonths();
        BigDecimal amountCredit = BigDecimal.valueOf(random.nextInt(100000 - 3000 + 1) + 3000);
        BigDecimal monthlyPayment = BigDecimal.valueOf(Math.round(amountCredit.doubleValue() / countMonth));
        List<Employee> creditEmployees = bank.getEmployees().stream().filter(Employee::isCanIssueCredit).toList();
        Employee creditEmployee = creditEmployees.get(random.nextInt(creditEmployees.size()));
        List<PaymentAccount> bankPaymentAccounts = user.getPaymentAccounts().stream()
                .filter(x -> x.getBank().equals(bank)).toList();
        PaymentAccount bankPaymentAccount = bankPaymentAccounts.get(random.nextInt(bankPaymentAccounts.size()));
        return new CreditAccount(id, user, bank, startDate, finishDate, countMonth, amountCredit, monthlyPayment,
                creditEmployee, bankPaymentAccount);
    }
}
