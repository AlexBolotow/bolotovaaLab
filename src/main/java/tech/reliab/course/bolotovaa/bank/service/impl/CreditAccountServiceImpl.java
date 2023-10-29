package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.CreditAccount;
import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;
import tech.reliab.course.bolotovaa.bank.service.CreditAccountService;

public class CreditAccountServiceImpl implements CreditAccountService {
    @Override
    public CreditAccount createCreditAccount(CreditAccount creditAccount) {
        if (creditAccount == null) {
            return null;
        }

        if (creditAccount.getUser() == null) {
            return null;
        }

        if (creditAccount.getPaymentAccount() == null) {
            return null;
        }

        if (creditAccount.getBank() == null) {
            return null;
        }

        if (creditAccount.getStartCredit().isAfter(creditAccount.getFinishCredit())) {
            return null;
        }

        if (creditAccount.getInterestRate() > creditAccount.getBank().getInterestRate()) {
            return null;
        }

        return new CreditAccount(creditAccount);
    }

    @Override
    public boolean updatePaymentAccount(CreditAccount creditAccount, PaymentAccount paymentAccount) {
        if (creditAccount != null && paymentAccount != null) {
            if (paymentAccount.getUser() == creditAccount.getUser()) {
                creditAccount.setPaymentAccount(paymentAccount);
                return true;
            }
        }
        return false;
    }
}
