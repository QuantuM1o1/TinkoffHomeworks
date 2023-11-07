package edu.hw5.Task8;

public class Fifth {
    private Fifth() {
    }

    public static boolean everyOddIs1(String input) {
        return input.matches("^1([01]($|1))*$");
    }
}
