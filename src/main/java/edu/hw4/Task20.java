package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task20 {
    private Task20() {
    }

    public static Map<String, String> moreReadableErrorMessages(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors
                .toMap(Animal::name, animal -> ValidationError
                    .checkForErrors(animal).stream()
                    .map(ValidationError::errorField)
                    .collect(Collectors.joining(", "))));
    }
}
