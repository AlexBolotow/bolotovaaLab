package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.Bank;
import tech.reliab.course.bolotovaa.bank.entity.CreditAccount;
import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;
import tech.reliab.course.bolotovaa.bank.entity.User;
import tech.reliab.course.bolotovaa.bank.service.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(User user) {
        if (user == null) {
            return null;
        }

        if (user.getSalary().doubleValue() < 0) {
            return null;
        }

        if (user.getBanks().size() < 1) {
            return null;
        }

        return new User(user);
    }

    @Override
    public boolean addBank(User user, Bank bank) {
        if (user != null && bank != null) {
            if (user.getBanks().contains(bank)) {
                return false;
            }

            ArrayList<Bank> newBanks = user.getBanks();
            newBanks.add(bank);
            user.setBanks(newBanks);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBank(User user, Bank bank) {
        if (user != null && bank != null) {
            if (!user.getBanks().contains(bank)) {
                return false;
            }

            ArrayList<Bank> newBanks = user.getBanks();
            newBanks.remove(bank);
            user.setBanks(newBanks);
            return true;
        }
        return false;
    }

    @Override
    public boolean addCreditAccount(User user, CreditAccount creditAccount) {
        if (user != null && creditAccount != null) {
            if (user.getCreditAccounts().contains(creditAccount)) {
                return false;
            }

            ArrayList<CreditAccount> newCreditAccounts = user.getCreditAccounts();
            newCreditAccounts.add(creditAccount);
            user.setCreditAccounts(newCreditAccounts);
            creditAccount.setUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCreditAccount(User user, CreditAccount creditAccount) {
        if (user != null && creditAccount != null) {
            if (!user.getCreditAccounts().contains(creditAccount)) {
                return false;
            }

            ArrayList<CreditAccount> newCreditAccounts = user.getCreditAccounts();
            newCreditAccounts.remove(creditAccount);
            user.setCreditAccounts(newCreditAccounts);
            creditAccount.setUser(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPaymentAccount(User user, PaymentAccount paymentAccount) {
        if (user != null && paymentAccount != null) {
            if (user.getPaymentAccounts().contains(paymentAccount)) {
                return false;
            }

            ArrayList<PaymentAccount> newPaymentAccounts = user.getPaymentAccounts();
            newPaymentAccounts.add(paymentAccount);
            user.setPaymentAccounts(newPaymentAccounts);
            paymentAccount.setUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePaymentAccount(User user, PaymentAccount paymentAccount) {
        if (user != null && paymentAccount != null) {
            if (!user.getPaymentAccounts().contains(paymentAccount)) {
                return false;
            }

            ArrayList<PaymentAccount> newPaymentAccounts = user.getPaymentAccounts();
            newPaymentAccounts.remove(paymentAccount);
            user.setPaymentAccounts(newPaymentAccounts);
            paymentAccount.setUser(null);
            return true;
        }
        return false;
    }
}
