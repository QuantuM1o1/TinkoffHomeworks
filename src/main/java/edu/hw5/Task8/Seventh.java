package edu.hw5.Task8;

public class Seventh {
    private Seventh() {
    }

    public static boolean noConsecutive1s(String input) {
        return input.matches("^(?![01]*11[01]*)[01]+$");
    }
}
