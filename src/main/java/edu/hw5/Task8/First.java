package edu.hw5.Task8;

public class First {
    private First() {
    }

    public static boolean oddLength(String input) {
        return input.matches("^([01]{2})*[01]$");
    }
}
