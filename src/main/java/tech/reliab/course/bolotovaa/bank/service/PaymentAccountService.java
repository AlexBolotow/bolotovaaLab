package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;

import java.math.BigDecimal;

public interface PaymentAccountService {
    PaymentAccount createPaymentAccount(PaymentAccount paymentAccount);

    boolean updateAmountMoney(PaymentAccount paymentAccount, BigDecimal amountMoney);
}
