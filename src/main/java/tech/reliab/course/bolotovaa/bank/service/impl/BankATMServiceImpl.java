package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.BankATM;
import tech.reliab.course.bolotovaa.bank.enums.BankATMStatus;
import tech.reliab.course.bolotovaa.bank.service.BankATMService;

import java.math.BigDecimal;

public class BankATMServiceImpl implements BankATMService {
    @Override
    public BankATM createBankAtm(BankATM bankAtm) {
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

        if (BankATM.MAX_TOTAL_MONEY.compareTo(bankAtm.getTotalMoney()) < 0) {
            return null;
        }

        if (bankAtm.getTotalMoney().doubleValue() < 0) {
            return null;
        }

        return new BankATM(bankAtm);
    }

    @Override
    public boolean depositMoney(BankATM bankAtm, BigDecimal amount) {
        if (bankAtm != null) {
            if (bankAtm.getStatus() == BankATMStatus.NOT_WORK || !bankAtm.isDepositMoney()) {
                return false;
            }

            //не переполнится ли банкомат при депозите
            if (BankATM.MAX_TOTAL_MONEY.compareTo(bankAtm.getTotalMoney().add(amount)) < 0) {
                return false;
            }

            bankAtm.setTotalMoney(bankAtm.getTotalMoney().add(amount));
            return true;
        }
        return false;
    }

    @Override
    public boolean withdrawMoney(BankATM bankAtm, BigDecimal amount) {
        if (bankAtm != null) {
            if (bankAtm.getStatus() == BankATMStatus.NOT_WORK || !bankAtm.isWithdrawMoney()) {
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
