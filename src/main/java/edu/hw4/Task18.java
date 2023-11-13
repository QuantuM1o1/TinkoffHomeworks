package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Task18 {
    private Task18() {
    }

    public static Animal heaviestFish(List<List<Animal>> animalsList) {
        return animalsList.stream()
            .flatMap(Collection::stream)
            .toList()
            .stream()
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparing(Animal::weight))
            .orElse(null);
    }
}
