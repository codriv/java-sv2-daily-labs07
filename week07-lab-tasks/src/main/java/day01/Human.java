package day01;

import java.time.LocalDate;

public class Human {
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        if (!(this.name = name).matches("\\S+ \\S+") ||
                LocalDate.now().getYear() - (this.yearOfBirth = yearOfBirth) > 120) {
            throw new IllegalArgumentException("Rossz adat!");
        }
    }
}
