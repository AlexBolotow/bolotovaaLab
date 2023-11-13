package tech.reliab.course.bolotovaa.bank.utils.generators;

import tech.reliab.course.bolotovaa.bank.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class RandomEmployeeGenerator {
    private static final String[] positions = {"Service employee", "Manager", "Supervisor"};

    public static Employee getRandomEmployee(long id) {
        Random random = new Random();
        String position = positions[random.nextInt(positions.length)];
        boolean canIssueCredit = !position.equals("Service employee");
        boolean isWorkRemotely = false;
        if (position.equals("Manager") || position.equals("Supervisor")) {
            isWorkRemotely = random.nextBoolean();
        }

        return new Employee(id, RandomHumanNameGenerator.getRandomHumanName(),
                RandomDateGenerator.getRandomDate(LocalDate.of(1963, 1, 1),
                        LocalDate.now().minusDays(6570)), position, null, canIssueCredit, null, isWorkRemotely,
                BigDecimal.valueOf(random.nextInt(10000 - 1000 + 1) + 1000));
    }

    public static Employee getRandomServiceEmployee(long id) {
        Random random = new Random();
        return new Employee(id, RandomHumanNameGenerator.getRandomHumanName(),
                RandomDateGenerator.getRandomDate(LocalDate.of(1963, 1, 1),
                        LocalDate.now().minusDays(6570)), positions[0], null, false, null, false,
                BigDecimal.valueOf(random.nextInt(10000 - 1000 + 1) + 1000));
    }
}

