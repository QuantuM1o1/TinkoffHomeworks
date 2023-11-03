package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task7 {
    private Task7() {
    }

    public static Animal oldestByK(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }
}
