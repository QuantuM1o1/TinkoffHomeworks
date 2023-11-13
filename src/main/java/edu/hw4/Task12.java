package edu.hw4;

import java.util.List;

public class Task12 {
    private Task12() {
    }

    public static Integer weightMoreThanHeight(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .mapToInt(animal -> 1)
            .sum();
    }
}
