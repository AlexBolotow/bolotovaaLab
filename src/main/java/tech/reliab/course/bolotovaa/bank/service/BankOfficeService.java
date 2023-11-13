package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.BankATM;
import tech.reliab.course.bolotovaa.bank.entity.BankOffice;

import java.math.BigDecimal;
import java.util.List;

public interface BankOfficeService {
    BankOffice createBankOffice(BankOffice bankOffice);

    boolean depositMoney(BankOffice bankOffice, BigDecimal amount);

    boolean withdrawMoney(BankOffice bankOffice, BigDecimal amount);

    boolean addBankATM(BankOffice bankOffice, List<BankATM> bankATMS);

    boolean deleteBankATM(BankOffice bankOffice, List<BankATM> bankATMS);
}
