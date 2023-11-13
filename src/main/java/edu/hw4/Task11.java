package edu.hw4;

import java.util.List;

public class Task11 {
    public static final int MIN_HEIGHT = 100;

    private Task11() {
    }

    public static List<Animal> bitesAndBig(List<Animal> animals) {
        return animals.stream()
            .filter(Animal::bites)
            .filter(animal -> animal.height() > MIN_HEIGHT)
            .toList();
    }
}
