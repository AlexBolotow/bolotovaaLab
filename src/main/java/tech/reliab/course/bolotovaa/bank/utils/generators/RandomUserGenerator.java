package tech.reliab.course.bolotovaa.bank.utils.generators;

import tech.reliab.course.bolotovaa.bank.entity.User;

import java.time.LocalDate;
import java.util.Random;

public class RandomUserGenerator {
    private static final String[] workPlaces = {"TechHub", "InnovateCo", "CreativeSpace", "ElevateOffice", "NexusCorp",
            "CollaboraZone", "InspireHQ", "FusionWorks", "EmpowerLabs", "EfficiencyInc"};

    public static User getRandomUser(long id) {
        Random random = new Random();
        return new User(id, RandomHumanNameGenerator.getRandomHumanName(),
                RandomDateGenerator.getRandomDate(LocalDate.of(1963, 1, 1),
                        LocalDate.now().minusDays(6570)), workPlaces[random.nextInt(workPlaces.length)]);
    }
}
