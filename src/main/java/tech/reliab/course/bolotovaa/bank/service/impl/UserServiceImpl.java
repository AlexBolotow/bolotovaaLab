package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.Bank;
import tech.reliab.course.bolotovaa.bank.entity.CreditAccount;
import tech.reliab.course.bolotovaa.bank.entity.PaymentAccount;
import tech.reliab.course.bolotovaa.bank.entity.User;
import tech.reliab.course.bolotovaa.bank.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(User user) {
        if (user == null) {
            return null;
        }

        if (user.getSalary().doubleValue() < 0) {
            return null;
        }

        return new User(user);
    }

    @Override
    public boolean addBanks(User user, List<Bank> banks) {
        if (user != null && banks != null) {
            if (user.getBanks() != null) {
                for (Bank bank : banks) {
                    if (user.getBanks().contains(bank)) {
                        return false;
                    }
                }

                List<Bank> newBanks = user.getBanks();
                newBanks.addAll(banks);
                user.setBanks(newBanks);
            } else {
                user.setBanks(banks);
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBanks(User user, List<Bank> banks) {
        if (user != null && banks != null) {
            for (Bank bank : banks) {
                if (!user.getBanks().contains(bank)) {
                    return false;
                }
            }

            List<Bank> newBanks = user.getBanks();
            newBanks.removeAll(banks);
            user.setBanks(newBanks);
            return true;
        }
        return false;
    }

    @Override
    public boolean addCreditAccounts(User user, List<CreditAccount> creditAccounts) {
        if (user != null && creditAccounts != null) {
            for (CreditAccount creditAccount : creditAccounts)
                if (user.getCreditAccounts().contains(creditAccount)) {
                    return false;
                }

            List<CreditAccount> newCreditAccounts = user.getCreditAccounts();
            creditAccounts.forEach(x -> x.setUser(user));
            newCreditAccounts.addAll(creditAccounts);
            user.setCreditAccounts(newCreditAccounts);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCreditAccounts(User user, List<CreditAccount> creditAccounts) {
        if (user != null && creditAccounts != null) {
            for (CreditAccount creditAccount : creditAccounts)
                if (!user.getCreditAccounts().contains(creditAccount)) {
                    return false;
                }

            List<CreditAccount> newCreditAccounts = user.getCreditAccounts();
            creditAccounts.forEach(x -> x.setUser(null));
            newCreditAccounts.removeAll(creditAccounts);
            user.setCreditAccounts(newCreditAccounts);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPaymentAccounts(User user, List<PaymentAccount> paymentAccounts) {
        if (user != null && paymentAccounts != null) {
            for (PaymentAccount paymentAccount : paymentAccounts) {
                if (user.getPaymentAccounts().contains(paymentAccount)) {
                    return false;
                }
            }

            List<PaymentAccount> newPaymentAccounts = user.getPaymentAccounts();
            paymentAccounts.forEach(x -> x.setUser(user));
            newPaymentAccounts.addAll(paymentAccounts);
            user.setPaymentAccounts(newPaymentAccounts);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePaymentAccounts(User user, List<PaymentAccount> paymentAccounts) {
        if (user != null && paymentAccounts != null) {
            for (PaymentAccount paymentAccount : paymentAccounts) {
                if (!user.getPaymentAccounts().contains(paymentAccount)) {
                    return false;
                }
            }

            List<PaymentAccount> newPaymentAccounts = user.getPaymentAccounts();
            paymentAccounts.forEach(x -> x.setUser(null));
            newPaymentAccounts.removeAll(paymentAccounts);
            user.setPaymentAccounts(newPaymentAccounts);
            return true;
        }
        return false;
    }
}
