package edu.hw4;

import java.util.HashSet;
import java.util.Set;

public record ValidationError(String nameOfError, String errorField) {
    private static Set<ValidationError> errors;
    private static Animal animal;
    private static final String ERROR_IN_NAME = "Name";
    private static final String ERROR_IN_AGE = "Age";
    private static final String ERROR_IN_HEIGHT = "Height";
    private static final String ERROR_IN_WEIGHT = "Weight";
    private static final String ERROR_IN_TYPE = "Type";
    private static final String AGE_MAX_MESSAGE = "Age is too high";
    private static final String HEIGHT_MAX_MESSAGE = "Height is too high";
    private static final String WEIGHT_MAX_MESSAGE = "Weight is too high";
    private static final String CANT_VALIDATE_THIS_TYPE = "No such animal type was found";
    private static final int MAX_CAT_AGE = 38;
    private static final int MAX_BIRD_AGE = 118;
    private static final int MAX_DOG_AGE = 31;
    private static final int MAX_FISH_AGE = 500;
    private static final int MAX_SPIDER_AGE = 43;
    private static final int MAX_CAT_HEIGHT = 119;
    private static final int MAX_BIRD_HEIGHT = 270;
    private static final int MAX_DOG_HEIGHT = 112;
    private static final int MAX_FISH_HEIGHT = 2500;
    private static final int MAX_SPIDER_HEIGHT = 28;
    private static final int MAX_CAT_WEIGHT = 11;
    private static final int MAX_BIRD_WEIGHT = 130;
    private static final int MAX_DOG_WEIGHT = 155;
    private static final int MAX_FISH_WEIGHT = 34000;
    private static final int MAX_SPIDER_WEIGHT = 1;

    public static Set<ValidationError> checkForErrors(Animal animalToCheck) {
        animal = animalToCheck;
        errors = new HashSet<>();
        checkAge();
        checkHeight();
        checkName();
        checkWeight();
        return errors;
    }

    private static void checkName() {
        if (animal.name() == null) {
            errors.add(new ValidationError("Name is null", ERROR_IN_NAME));
            return;
        }
        if (!animal.name().matches("^(?=.*[A-Za-z])[A-Za-z0-9 -]+$")) {
            errors.add(new ValidationError("Name isn't correct", ERROR_IN_NAME));
        }
    }

    private static void checkAge() {
        if (animal.age() < 0) {
            errors.add(new ValidationError("Age is a negative number", ERROR_IN_AGE));
            return;
        }
        switch (animal.type()) {
            case CAT -> {
                if (animal.age() > MAX_CAT_AGE) {
                    errors.add(new ValidationError(AGE_MAX_MESSAGE, ERROR_IN_AGE));
                }
            }
            case BIRD -> {
                if (animal.age() > MAX_BIRD_AGE) {
                    errors.add(new ValidationError(AGE_MAX_MESSAGE, ERROR_IN_AGE));
                }
            }
            case DOG -> {
                if (animal.age() > MAX_DOG_AGE) {
                    errors.add(new ValidationError(AGE_MAX_MESSAGE, ERROR_IN_AGE));
                }
            }
            case FISH -> {
                if (animal.age() > MAX_FISH_AGE) {
                    errors.add(new ValidationError(AGE_MAX_MESSAGE, ERROR_IN_AGE));
                }
            }
            case SPIDER -> {
                if (animal.age() > MAX_SPIDER_AGE) {
                    errors.add(new ValidationError(AGE_MAX_MESSAGE, ERROR_IN_AGE));
                }
            }
            default -> errors.add(new ValidationError(CANT_VALIDATE_THIS_TYPE, ERROR_IN_TYPE));
        }
    }

    private static void checkHeight() {
        if (animal.height() < 0) {
            errors.add(new ValidationError("Height is a negative number", ERROR_IN_HEIGHT));
            return;
        }
        switch (animal.type()) {
            case CAT -> {
                if (animal.height() > MAX_CAT_HEIGHT) {
                    errors.add(new ValidationError(HEIGHT_MAX_MESSAGE, ERROR_IN_HEIGHT));
                }
            }
            case BIRD -> {
                if (animal.height() > MAX_BIRD_HEIGHT) {
                    errors.add(new ValidationError(HEIGHT_MAX_MESSAGE, ERROR_IN_HEIGHT));
                }
            }
            case DOG -> {
                if (animal.height() > MAX_DOG_HEIGHT) {
                    errors.add(new ValidationError(HEIGHT_MAX_MESSAGE, ERROR_IN_HEIGHT));
                }
            }
            case FISH -> {
                if (animal.height() > MAX_FISH_HEIGHT) {
                    errors.add(new ValidationError(HEIGHT_MAX_MESSAGE, ERROR_IN_HEIGHT));
                }
            }
            case SPIDER -> {
                if (animal.height() > MAX_SPIDER_HEIGHT) {
                    errors.add(new ValidationError(HEIGHT_MAX_MESSAGE, ERROR_IN_HEIGHT));
                }
            }
            default -> errors.add(new ValidationError(CANT_VALIDATE_THIS_TYPE, ERROR_IN_TYPE));
        }
    }

    private static void checkWeight() {
        if (animal.weight() < 0) {
            errors.add(new ValidationError("Weight is a negative number", ERROR_IN_WEIGHT));
            return;
        }
        switch (animal.type()) {
            case CAT -> {
                if (animal.weight() > MAX_CAT_WEIGHT) {
                    errors.add(new ValidationError(WEIGHT_MAX_MESSAGE, ERROR_IN_WEIGHT));
                }
            }
            case BIRD -> {
                if (animal.weight() > MAX_BIRD_WEIGHT) {
                    errors.add(new ValidationError(WEIGHT_MAX_MESSAGE, ERROR_IN_WEIGHT));
                }
            }
            case DOG -> {
                if (animal.weight() > MAX_DOG_WEIGHT) {
                    errors.add(new ValidationError(WEIGHT_MAX_MESSAGE, ERROR_IN_WEIGHT));
                }
            }
            case FISH -> {
                if (animal.weight() > MAX_FISH_WEIGHT) {
                    errors.add(new ValidationError(WEIGHT_MAX_MESSAGE, ERROR_IN_WEIGHT));
                }
            }
            case SPIDER -> {
                if (animal.weight() > MAX_SPIDER_WEIGHT) {
                    errors.add(new ValidationError(WEIGHT_MAX_MESSAGE, ERROR_IN_WEIGHT));
                }
            }
            default -> errors.add(new ValidationError(CANT_VALIDATE_THIS_TYPE, ERROR_IN_TYPE));
        }
    }
}
