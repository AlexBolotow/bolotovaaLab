package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.BankATM;
import tech.reliab.course.bolotovaa.bank.entity.Employee;
import tech.reliab.course.bolotovaa.bank.enums.BankATMStatus;
import tech.reliab.course.bolotovaa.bank.service.BankAtmService;

import java.math.BigDecimal;

public class BankAtmServiceImpl implements BankAtmService {
    @Override
    public BankATM createBankAtm(BankATM bankAtm) {
        if (bankAtm.getBank() == null) {
            System.out.println("1");
            return null;
        }

        if (!bankAtm.getAddress().equals(bankAtm.getOffice().getAddress())) {
            System.out.println("2");
            return null;
        }

        if (bankAtm.getBank().getTotalMoney().compareTo(bankAtm.getTotalMoney()) < 0) {
            System.out.println("3");
            return null;
        }

        if (BankATM.MAX_TOTAL_MONEY.compareTo(bankAtm.getTotalMoney()) < 0) {
            System.out.println("4");
            return null;
        }

        if (bankAtm.getTotalMoney().doubleValue() < 0) {
            System.out.println("5");
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

    @Override
    public boolean updateServiceEmployee(BankATM bankAtm, Employee employee) {
        if (bankAtm != null && employee != null) {
            if (employee.getPosition().equals("Service employee")) {
                bankAtm.setServiceEmployee(employee);
                return true;
            }
        }
        return false;
    }
}
