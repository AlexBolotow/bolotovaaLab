package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.BankAtm;

import java.math.BigDecimal;

public interface BankAtmService {
    BankAtm createBankAtm(BankAtm bankAtm);

    boolean depositMoney(BankAtm bankAtm, BigDecimal amount);

    boolean withdrawMoney(BankAtm bankAtm, BigDecimal amount);
}
