package tech.reliab.course.bolotovaa.bank.utils.generators;

import tech.reliab.course.bolotovaa.bank.entity.BankOffice;
import tech.reliab.course.bolotovaa.bank.enums.BankOfficeStatus;

import java.math.BigDecimal;
import java.util.Random;

public class RandomBankOfficeGenerator {
    private static final String[] names = {"Swift Solutions", "Stellar Innovations", "Fusion Labs", "Apex Ventures",
            "Nexus Technologies", "Quantum Co.", "Stellaris Inc.", "Catalyst Enterprises", "Elevation Corporation",
            "Synergy Solutions"};

    private static String getRandomBankOfficeName() {
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    public static BankOffice getRandomBankOffice(long id) {
        Random random = new Random();
        return new BankOffice(id, getRandomBankOfficeName(),
                RandomAddressGenerator.getRandomAddress(), BankOfficeStatus.WORK, true, true,
                true, true,
                BigDecimal.valueOf(random.nextInt(300000 - 100000 + 1) + 100000),
                BigDecimal.valueOf(random.nextInt(50000 - 10000 + 1) + 10000));
    }
}
