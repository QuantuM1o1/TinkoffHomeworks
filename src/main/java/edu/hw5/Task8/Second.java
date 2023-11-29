package edu.hw5.Task8;

public class Second {
    private Second() {
    }

    public static boolean startsWith0andOddOr1andEven(String input) {
        return input.matches("^0([01]{2})*|1[01]([01]{2})*$");
    }
}
