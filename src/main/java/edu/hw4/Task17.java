package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task17 {
    private Task17() {
    }

    public static Boolean spidersAreScary(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG | animal.type() == Animal.Type.SPIDER)
            .collect(Collectors
                .groupingBy(Animal::type, Collectors
                    .collectingAndThen(Collectors
                            .averagingInt(animal -> animal.bites() ? 1 : 0), average -> average)))
            .entrySet()
            .stream()
            .reduce((key1, key2) -> {
                if (key1.getKey() == Animal.Type.SPIDER) {
                    key1.setValue(key2.getValue() - key1.getValue());
                } else {
                    key1.setValue(key1.getValue() - key2.getValue());
                }
                return key1;
            }).orElse(Map.entry(Animal.Type.CAT, 0D))
            .getValue() < 0;
    }
}
