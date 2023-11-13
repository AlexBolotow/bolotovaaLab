package tech.reliab.course.bolotovaa.bank.utils.generators;

import java.util.Random;

public class RandomAddressGenerator {
    private static final String[] countries = {"Sweden", "Brazil", "USA", "Australia", "Mexico", "Egypt",
            "Russia", "Canada", "India", "Japan"};
    private static final String[] cities = {"Willow Creek", "Sunnydale", "Rosewood", "Maplewood", "Oakville",
            "Riverdale", "Hazelwood", "Windsor Hills", "Pinehurst", "Cedarville"};
    private static final String[] streets = {"Maple Avenue", "Main Street", "Oak Drive", "Cedar Lane", "Elm Street",
            "Willow Lane", "Pine Avenue", "Birch Road", "Cherry Street", "Sycamore Lane"};

    public static String getRandomAddress() {
        Random random = new Random();
        return random.nextInt(1000) + " " + streets[random.nextInt(streets.length)] + ", " +
                cities[random.nextInt(cities.length)] + ", " + countries[random.nextInt(countries.length)];
    }
}
