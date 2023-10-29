package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.Bank;
import tech.reliab.course.bolotovaa.bank.entity.CreditAccount;
import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;
import tech.reliab.course.bolotovaa.bank.entity.User;

public interface UserService {
    User createUser(User user);

    boolean addBank(User user, Bank bank);

    boolean deleteBank(User user, Bank bank);

    boolean addCreditAccount(User user, CreditAccount creditAccount);

    boolean deleteCreditAccount(User user, CreditAccount creditAccount);

    boolean addPaymentAccount(User user, PaymentAccount paymentAccount);

    boolean deletePaymentAccount(User user, PaymentAccount paymentAccount);
}
