package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.BankATM;
import tech.reliab.course.bolotovaa.bank.entity.BankOffice;
import tech.reliab.course.bolotovaa.bank.enums.BankOfficeStatus;
import tech.reliab.course.bolotovaa.bank.service.BankOfficeService;

import java.math.BigDecimal;
import java.util.List;

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
    public boolean addBankATM(BankOffice bankOffice, List<BankATM> bankATMS) {
        if (bankOffice != null && bankATMS != null) {
            if (bankOffice.isAtmPossible()) {
                for (BankATM bankATM : bankATMS) {
                    if (bankOffice.getBankATMS().contains(bankATM)) {
                        return false;
                    }
                }

                List<BankATM> newBankATMS = bankOffice.getBankATMS();
                newBankATMS.addAll(bankATMS);
                bankOffice.setBankATMS(bankATMS);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean deleteBankATM(BankOffice bankOffice, List<BankATM> bankATMS) {
        if (bankOffice != null && bankATMS != null) {
            if (bankOffice.isAtmPossible()) {
                for (BankATM bankATM : bankATMS) {
                    if (!bankOffice.getBankATMS().contains(bankATM)) {
                        return false;
                    }
                }

                List<BankATM> newBankATMS = bankOffice.getBankATMS();
                newBankATMS.removeAll(bankATMS);
                bankOffice.setBankATMS(bankATMS);
                return true;
            }
        }
        return false;
    }
}
