package edu.hw5.Task8;

public class Third {
    private Third() {
    }

    public static boolean threeZeros(String input) {
        return input.matches("^(1*01*01*0)*1*$");
    }
}
