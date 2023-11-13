package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.Bank;
import tech.reliab.course.bolotovaa.bank.entity.CreditAccount;
import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;
import tech.reliab.course.bolotovaa.bank.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    boolean addBanks(User user, List<Bank> banks);

    boolean deleteBanks(User user, List<Bank> banks);

    boolean addCreditAccounts(User user, List<CreditAccount> creditAccounts);

    boolean deleteCreditAccounts(User user, List<CreditAccount> creditAccounts);

    boolean addPaymentAccounts(User user, List<PaymentAccount> paymentAccounts);

    boolean deletePaymentAccounts(User user, List<PaymentAccount> paymentAccounts);
}
