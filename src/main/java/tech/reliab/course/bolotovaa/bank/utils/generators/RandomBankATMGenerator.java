package tech.reliab.course.bolotovaa.bank.utils.generators;

import tech.reliab.course.bolotovaa.bank.entity.Bank;
import tech.reliab.course.bolotovaa.bank.entity.BankATM;
import tech.reliab.course.bolotovaa.bank.entity.BankOffice;
import tech.reliab.course.bolotovaa.bank.enums.BankATMStatus;

import java.math.BigDecimal;
import java.util.Random;

public class RandomBankATMGenerator {
    private static final String[] names = {"Cash Express", "Quick Cash", "Money Mart", "ATM Zone", "CashLink",
            "Easy Money", "Swift ATM", "MoneyWave", "Cash Oasis", "Rapid Cash"};

    private static String getRandomBankATMName() {
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    public static BankATM getRandomBankATM(long id, Bank bank, BankOffice bankOffice) {
        Random random = new Random();
        return new BankATM(id, getRandomBankATMName(), bankOffice.getAddress(),
                BankATMStatus.WORK, bank, bankOffice, null, true,
                true,
                BigDecimal.valueOf(random.nextInt(24000 - 1000 + 1) + 1000),
                BigDecimal.valueOf(random.nextInt(2500 - 500 + 1) + 500));
    }
}
