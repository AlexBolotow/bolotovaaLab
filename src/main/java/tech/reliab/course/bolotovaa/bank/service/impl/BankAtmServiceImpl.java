package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.BankAtm;
import tech.reliab.course.bolotovaa.bank.enums.BankAtmStatus;
import tech.reliab.course.bolotovaa.bank.service.BankAtmService;

import java.math.BigDecimal;

public class BankAtmServiceImpl implements BankAtmService {
    @Override
    public BankAtm createBankAtm(BankAtm bankAtm) {
        if (bankAtm.getBank() == null) {
            return null;
        }

        if (!bankAtm.getAddress().equals(bankAtm.getOffice().getAddress())) {
            return null;
        }

        if (bankAtm.getServiceEmployee() == null) {
            return null;
        }

        if (bankAtm.getBank().getTotalMoney().compareTo(bankAtm.getTotalMoney()) < 0) {
            return null;
        }

        if (BankAtm.MAX_TOTAL_MONEY.compareTo(bankAtm.getTotalMoney()) < 0) {
            return null;
        }

        if (bankAtm.getTotalMoney().doubleValue() < 0) {
            return null;
        }

        return new BankAtm(bankAtm);
    }

    @Override
    public boolean depositMoney(BankAtm bankAtm, BigDecimal amount) {
        if (bankAtm != null) {
            if (bankAtm.getStatus() == BankAtmStatus.NOT_WORK || !bankAtm.isDepositMoney()) {
                return false;
            }

            //не переполнится ли банкомат при депозите
            if (BankAtm.MAX_TOTAL_MONEY.compareTo(bankAtm.getTotalMoney().add(amount)) < 0) {
                return false;
            }

            bankAtm.setTotalMoney(bankAtm.getTotalMoney().add(amount));
            return true;
        }
        return false;
    }

    @Override
    public boolean withdrawMoney(BankAtm bankAtm, BigDecimal amount) {
        if (bankAtm != null) {
            if (bankAtm.getStatus() == BankAtmStatus.NOT_WORK || !bankAtm.isWithdrawMoney()) {
                return false;
            }

            if (bankAtm.getTotalMoney().compareTo(amount) < 0) {
                return false;
            }

            bankAtm.setTotalMoney(bankAtm.getTotalMoney().subtract(amount));
            return true;
        }
        return false;
    }
}
