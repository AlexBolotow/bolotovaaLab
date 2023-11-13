package tech.reliab.course.bolotovaa.bank.utils.generators;

import java.util.Random;

public class RandomHumanNameGenerator {
    private static final String[] names = {"Liam", "Noah", "Jackson", "Ethan", "Owen", "Caleb", "Lucas", "Sebastian",
            "Elijah", "Aiden", "Emma", "Olivia", "Ava", "Sophia", "Isabella", "Mia", "Charlotte", "Amelia", "Harper",
            "Evelyn"};
    private static final String[] surnames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Davis", "Miller",
            "Wilson", "Anderson", "Rodriguez", "Martinez", "Taylor", "Thomas", "Garcia", "Robinson", "Clark", "Lewis",
            "Lee", "Walker", "Hall"};

    public static String getRandomHumanName() {
        Random random = new Random();
        return names[random.nextInt(names.length)] + " " + surnames[random.nextInt(surnames.length)];
    }
}
