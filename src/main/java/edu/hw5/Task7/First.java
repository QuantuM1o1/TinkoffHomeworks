package edu.hw5.Task7;

public class First {
    private First() {
    }

    public static boolean threeSymbolsThirdOneIs0(String input) {
        return input.matches("^[01]{2}0[01]*$");
    }
}
