package edu.hw4;

import java.util.List;

public class Task14 {
    private Task14() {
    }

    public static Boolean bigDog(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .anyMatch(animal -> animal.height() > k);
    }
}
