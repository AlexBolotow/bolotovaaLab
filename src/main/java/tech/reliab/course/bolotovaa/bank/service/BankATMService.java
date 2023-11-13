package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.BankATM;

import java.math.BigDecimal;

public interface BankATMService {
    BankATM createBankAtm(BankATM bankAtm);

    boolean depositMoney(BankATM bankAtm, BigDecimal amount);

    boolean withdrawMoney(BankATM bankAtm, BigDecimal amount);
}
