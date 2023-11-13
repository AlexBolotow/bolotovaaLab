package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.*;
import tech.reliab.course.bolotovaa.bank.service.BankService;

public class BankServiceImpl implements BankService {
    @Override
    public Bank createBank(Bank bank) {
        return new Bank(bank);
    }

    @Override
    public boolean addBankOffice(Bank bank, BankOffice bankOffice) {
        if (bank != null && bankOffice != null) {
            bank.setCountOffices(bank.getCountOffices() + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBankOffice(Bank bank, BankOffice bankOffice) {
        if (bank != null && bankOffice != null) {
            if (bank.getCountOffices() < 1) {
                throw new RuntimeException("Error: count bank offices = 0");
            }

            bank.setCountOffices(bank.getCountOffices() - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean addBankAtm(Bank bank, BankATM bankAtm) {
        if (bank != null && bankAtm != null) {
            bank.setCountATM(bank.getCountATM() + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBankAtm(Bank bank, BankATM bankAtm) {
        if (bank != null && bankAtm != null) {
            if (bank.getCountATM() < 1) {
                throw new RuntimeException("Error: count bank Atms = 0");
            }

            bank.setCountOffices(bank.getCountOffices() - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean addEmployee(Bank bank, Employee employee) {
        if (bank != null && employee != null) {
            bank.setCountEmployees(bank.getCountEmployees() + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(Bank bank, Employee employee) {
        if (bank != null && employee != null) {
            if (bank.getCountEmployees() < 1) {
                throw new RuntimeException("Error: count bank employees = 0");
            }

            bank.setCountEmployees(bank.getCountEmployees() - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean addClient(Bank bank, User user) {
        if (bank != null && user != null) {
            bank.setCountClients(bank.getCountClients() + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClient(Bank bank, User user) {
        if (bank != null && user != null) {
            if (bank.getCountClients() < 1) {
                throw new RuntimeException("Error: count bank clients = 0");
            }

            bank.setCountClients(bank.getCountClients() - 1);
            return true;
        }
        return false;
    }
}
