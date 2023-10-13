package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    static final int TEN_BASE = 10;

    public static int countDigits(int number) {
        int count = 0;
        int num = number;
        do {
            count++;
            num = num / TEN_BASE;
        }
        while (num != 0);
        return count;
    }
}
