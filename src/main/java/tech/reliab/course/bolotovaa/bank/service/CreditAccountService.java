package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.CreditAccount;
import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;

public interface CreditAccountService {
    CreditAccount createCreditAccount(CreditAccount creditAccount);

    boolean updatePaymentAccount(CreditAccount creditAccount, PaymentAccount paymentAccount);


}
