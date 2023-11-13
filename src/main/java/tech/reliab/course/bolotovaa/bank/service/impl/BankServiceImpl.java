package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.*;
import tech.reliab.course.bolotovaa.bank.service.BankService;

import java.util.List;

public class BankServiceImpl implements BankService {
    @Override
    public Bank createBank(Bank bank) {
        return new Bank(bank);
    }

    @Override
    public boolean addBankOffices(Bank bank, List<BankOffice> bankOffices) {
        if (bank != null && bankOffices != null) {
            for (BankOffice bankOffice : bankOffices) {
                if (bank.getBankOffices().contains(bankOffice)) {
                    return false;
                }
            }

            List<BankOffice> newBankOffices = bank.getBankOffices();
            newBankOffices.addAll(bankOffices);
            bank.setBankOffices(newBankOffices);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBankOffices(Bank bank, List<BankOffice> bankOffices) {
        if (bank != null && bankOffices != null) {
            for (BankOffice bankOffice : bankOffices) {
                if (!bank.getBankOffices().contains(bankOffice)) {
                    return false;
                }
            }

            List<BankOffice> newBankOffices = bank.getBankOffices();
            newBankOffices.removeAll(bankOffices);
            bank.setBankOffices(newBankOffices);
            return true;
        }
        return false;
    }

    @Override
    public boolean addBankATMS(Bank bank, List<BankATM> bankATMS) {
        if (bank != null && bankATMS != null) {
            for (BankATM bankATM : bankATMS) {
                if (bank.getBankATMS().contains(bankATM)) {
                    return false;
                }
            }

            List<BankATM> newBankATMS = bank.getBankATMS();
            bankATMS.forEach(x -> x.setBank(bank));
            newBankATMS.addAll(bankATMS);
            bank.setBankATMS(newBankATMS);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBankATMS(Bank bank, List<BankATM> bankATMS) {
        if (bank != null && bankATMS != null) {
            for (BankATM bankATM : bankATMS) {
                if (!bank.getBankATMS().contains(bankATM)) {
                    return false;
                }
            }

            List<BankATM> newBankATMS = bank.getBankATMS();
            bankATMS.forEach(x -> x.setBank(null));
            newBankATMS.removeAll(bankATMS);
            bank.setBankATMS(newBankATMS);
            return true;
        }
        return false;
    }

    @Override
    public boolean addEmployees(Bank bank, List<Employee> employees) {
        if (bank != null && employees != null) {
            for (Employee employee : employees) {
                if (bank.getEmployees().contains(employee)) {
                    return false;
                }
            }

            List<Employee> newEmployees = bank.getEmployees();
            employees.forEach(x -> x.setBank(bank));
            newEmployees.addAll(employees);
            bank.setEmployees(newEmployees);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployees(Bank bank, List<Employee> employees) {
        if (bank != null && employees != null) {
            for (Employee employee : employees) {
                if (!bank.getEmployees().contains(employee)) {
                    return false;
                }
            }

            List<Employee> newEmployees = bank.getEmployees();
            employees.forEach(x -> x.setBank(null));
            newEmployees.removeAll(employees);
            bank.setEmployees(newEmployees);
            return true;
        }
        return false;
    }

    @Override
    public boolean addUsers(Bank bank, List<User> users) {
        if (bank != null && users != null) {
            for (User user : users) {
                if (bank.getUsers().contains(user)) {
                    return false;
                }
            }

            List<User> newUsers = bank.getUsers();
            newUsers.addAll(users);
            bank.setUsers(newUsers);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUsers(Bank bank, List<User> users) {
        if (bank != null && users != null) {
            for (User user : users) {
                if (!bank.getUsers().contains(user)) {
                    return false;
                }
            }

            List<User> newUsers = bank.getUsers();
            newUsers.removeAll(users);
            bank.setUsers(newUsers);
            return true;
        }
        return false;
    }
}
