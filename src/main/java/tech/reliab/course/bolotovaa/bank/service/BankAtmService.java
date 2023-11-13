package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.BankATM;
import tech.reliab.course.bolotovaa.bank.entity.Employee;

import java.math.BigDecimal;

public interface BankAtmService {
    BankATM createBankAtm(BankATM bankAtm);

    boolean depositMoney(BankATM bankAtm, BigDecimal amount);

    boolean withdrawMoney(BankATM bankAtm, BigDecimal amount);

    boolean updateServiceEmployee(BankATM bankAtm, Employee employee);
}
