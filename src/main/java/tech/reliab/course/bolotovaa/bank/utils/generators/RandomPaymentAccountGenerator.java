package tech.reliab.course.bolotovaa.bank.utils.generators;

import tech.reliab.course.bolotovaa.bank.entity.Bank;
import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;
import tech.reliab.course.bolotovaa.bank.entity.User;

import java.math.BigDecimal;
import java.util.Random;

public class RandomPaymentAccountGenerator {
    public static PaymentAccount getRandomPaymentAccount(long id, User user, Bank bank) {
        Random random = new Random();
        return new PaymentAccount(id, user, bank, BigDecimal.valueOf(random.nextInt(bank.getTotalMoney().intValue())));
    }
}
