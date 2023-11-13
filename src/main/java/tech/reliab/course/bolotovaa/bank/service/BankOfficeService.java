package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.BankATM;
import tech.reliab.course.bolotovaa.bank.entity.BankOffice;

import java.math.BigDecimal;

public interface BankOfficeService {
    BankOffice createBankOffice(BankOffice bankOffice);

    boolean depositMoney(BankOffice bankOffice, BigDecimal amount);

    boolean withdrawMoney(BankOffice bankOffice, BigDecimal amount);

    boolean addBankAtm(BankOffice bankOffice, BankATM bankAtm);

    boolean deleteBankAtm(BankOffice bankOffice, BankATM bankAtm);
}
