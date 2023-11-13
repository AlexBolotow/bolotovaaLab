package tech.reliab.course.bolotovaa.bank.utils.generators;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateGenerator {
    public static LocalDate getRandomDate(LocalDate startDate, LocalDate endDate) {
        long randomEpochDay = ThreadLocalRandom.current().nextLong(startDate.toEpochDay(),
                endDate.toEpochDay() + 1);

        return LocalDate.ofEpochDay(randomEpochDay);
    }
}
