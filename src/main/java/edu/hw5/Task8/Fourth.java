package edu.hw5.Task8;

public class Fourth {
    private Fourth() {
    }

    public static boolean neither11nor111(String input) {
        return input.matches("^(?!11$|111$)[01]+$");
    }
}
