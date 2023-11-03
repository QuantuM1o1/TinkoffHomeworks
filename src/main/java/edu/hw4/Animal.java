package edu.hw4;

public record Animal(String name,
                     Type type,
                     Sex sex,
                     int age,
                     int height,
                     int weight,
                     boolean bites) {
    private final static int NUMBER_OF_LEGS_FOR_TETRAPODA = 4;
    private final static int NUMBER_OF_LEGS_FOR_ARACHNIDA = 8;

    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> NUMBER_OF_LEGS_FOR_TETRAPODA;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> NUMBER_OF_LEGS_FOR_ARACHNIDA;
        };
    }
}
