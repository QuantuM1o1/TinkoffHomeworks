package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    static final int K = 6174;
    static final int MIN_NUMBER = 1000;
    static final int MAX_NUMBER = 9999;
    static final int ALL1 = 1111;
    static final int ALL2 = 2222;
    static final int ALL3 = 3333;
    static final int ALL4 = 4444;
    static final int ALL5 = 5555;
    static final int ALL6 = 6666;
    static final int ALL7 = 7777;
    static final int ALL8 = 8888;
    static final int ALL9 = 9999;
    static final int NUMBER_OF_DIGITS = 4;
    static final int BASE_TO_ADD = 10;


    public static int countK(int number) {
        if (number <= MIN_NUMBER || number > MAX_NUMBER
            || number == ALL1 || number == ALL2
            || number == ALL3 || number == ALL4
            || number == ALL5 || number == ALL6
            || number == ALL7 || number == ALL8
            || number == ALL9) {
            return -1;
        }
        if (number == K) {
            return 0;
        }
        char[] ascendingNumber = ("" + number).toCharArray();
        Arrays.sort(ascendingNumber);
        char[] descendingNumber = new char[NUMBER_OF_DIGITS];
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            descendingNumber[i] = ascendingNumber[NUMBER_OF_DIGITS - 1 - i];
        }
        int newNumber = Integer.parseInt(new String(descendingNumber)) - Integer.parseInt(new String(ascendingNumber));
        if (newNumber < MIN_NUMBER) {
            newNumber = newNumber * BASE_TO_ADD;
        }
        return 1 + countK(newNumber);
    }
}
