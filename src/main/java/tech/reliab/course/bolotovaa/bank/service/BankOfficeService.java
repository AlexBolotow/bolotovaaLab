package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.BankAtm;
import tech.reliab.course.bolotovaa.bank.entity.BankOffice;

import java.math.BigDecimal;

public interface BankOfficeService {
    BankOffice createBankOffice(BankOffice bankOffice);

    boolean depositMoney(BankOffice bankOffice, BigDecimal amount);

    boolean withdrawMoney(BankOffice bankOffice, BigDecimal amount);

    boolean addBankAtm(BankOffice bankOffice, BankAtm bankAtm);

    boolean deleteBankAtm(BankOffice bankOffice, BankAtm bankAtm);
}
