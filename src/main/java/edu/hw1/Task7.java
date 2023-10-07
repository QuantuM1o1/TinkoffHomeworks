package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        if (n < 0) {
            return -1;
        }
        int numberForPower = n;
        int number = n;
        int power = 0;
        while ((numberForPower = numberForPower / 2) > 0) {
            power++;
        }
        for (int i = 0; i < shift; i++) {
            if (number >= Math.pow(2, power)) {
                number -= (int) Math.pow(2, power);
                number = number * 2;
                number++;
            } else {
                number = number * 2;
            }
        }
        return number;
    }

    public static int rotateRight(int n, int shift) {
        if (n < 0) {
            return -1;
        }
        int numberForPower = n;
        int number = n;
        int power = 0;
        while ((numberForPower = numberForPower / 2) > 0) {
            power++;
        }
        for (int i = 0; i < shift; i++) {
            if ((number % 2) != 0) {
                number = number / 2;
                number += (int) Math.pow(2, power);
            } else {
                number = number / 2;
            }
        }
        return number;
    }
}
