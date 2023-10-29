package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;
import tech.reliab.course.bolotovaa.bank.service.PaymentAccountService;

import java.math.BigDecimal;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    @Override
    public PaymentAccount createPaymentAccount(PaymentAccount paymentAccount) {
        if (paymentAccount == null) {
            return null;
        }

        if (paymentAccount.getUser() == null) {
            return null;
        }

        if (paymentAccount.getBank() == null) {
            return null;
        }

        if (paymentAccount.getAmountMoney().doubleValue() < 0) {
            return null;
        }

        return new PaymentAccount(paymentAccount);
    }

    @Override
    public boolean updateAmountMoney(PaymentAccount paymentAccount, BigDecimal amountMoney) {
        if (paymentAccount != null && amountMoney != null) {
            if (amountMoney.doubleValue() < 0) {
                return false;
            }

            paymentAccount.setAmountMoney(amountMoney);
            return true;
        }
        return false;
    }
}
