package edu.hw5.Task7;

public class Second {
    private Second() {
    }

    public static boolean firstAndLastAreEqual(String input) {
        return input.matches("^([01])[01]*\\1$");
    }
}
