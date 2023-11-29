package edu.hw5.Task7;

public class Third {
    private Third() {
    }

    public static boolean lengthIs1to3(String input) {
        return input.matches("^[01]{1,3}$");
    }
}
