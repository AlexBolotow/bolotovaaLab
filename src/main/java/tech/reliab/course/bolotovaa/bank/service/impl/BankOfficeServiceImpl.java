package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.BankAtm;
import tech.reliab.course.bolotovaa.bank.entity.BankOffice;
import tech.reliab.course.bolotovaa.bank.enums.BankOfficeStatus;
import tech.reliab.course.bolotovaa.bank.service.BankOfficeService;

import java.math.BigDecimal;

public class BankOfficeServiceImpl implements BankOfficeService {
    @Override
    public BankOffice createBankOffice(BankOffice bankOffice) {
        if (bankOffice == null) {
            return null;
        }

        if (BankOffice.MAX_TOTAL_MONEY.compareTo(bankOffice.getTotalMoney()) < 0) {
            return null;
        }

        if (bankOffice.getTotalMoney().doubleValue() < 0) {
            return null;
        }

        if (bankOffice.getRentPrice().doubleValue() < 0) {
            return null;
        }

        return new BankOffice(bankOffice);
    }

    @Override
    public boolean depositMoney(BankOffice bankOffice, BigDecimal amount) {
        if (bankOffice != null) {
            if (bankOffice.getStatus() == BankOfficeStatus.NOT_WORK || !bankOffice.isDepositMoney()) {
                return false;
            }

            if (BankOffice.MAX_TOTAL_MONEY.compareTo(bankOffice.getTotalMoney().add(amount)) < 0) {
                return false;
            }

            bankOffice.setTotalMoney(bankOffice.getTotalMoney().add(amount));
            return true;
        }
        return false;
    }

    @Override
    public boolean withdrawMoney(BankOffice bankOffice, BigDecimal amount) {
        if (bankOffice != null) {
            if (bankOffice.getStatus() == BankOfficeStatus.NOT_WORK || !bankOffice.isWithdrawMoney()) {
                return false;
            }

            if (bankOffice.getTotalMoney().compareTo(amount) < 0) {
                return false;
            }

            bankOffice.setTotalMoney(bankOffice.getTotalMoney().subtract(amount));
            return true;
        }
        return false;
    }

    @Override
    public boolean addBankAtm(BankOffice bankOffice, BankAtm bankAtm) {
        if (bankOffice != null && bankAtm != null) {
            if (bankOffice.isAtmPossible()) {
                bankOffice.setCountAtm(bankOffice.getCountAtm() + 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteBankAtm(BankOffice bankOffice, BankAtm bankAtm) {
        if (bankOffice != null && bankAtm != null) {
            if (bankOffice.getCountAtm() > 0) {
                bankOffice.setCountAtm(bankOffice.getCountAtm() - 1);
                return true;
            }
        }
        return false;
    }
}
