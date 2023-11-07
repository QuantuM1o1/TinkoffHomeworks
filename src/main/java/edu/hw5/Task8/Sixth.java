package edu.hw5.Task8;

public class Sixth {
    private Sixth() {
    }

    public static boolean min2ZerosAndMax1One(String input) {
        return input.matches("(^100+$)|(^00+10*$)|(^0+10+$)");
    }
}
