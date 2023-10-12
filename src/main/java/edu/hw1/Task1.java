package edu.hw1;

import java.util.Arrays;

public final class Task1 {
    private Task1() {
    }

    static final int SECONDS_IN_MINUTES = 60;

    public static int minutesToSeconds(String time) {
        int[] split = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        if ((split[1] < SECONDS_IN_MINUTES) && (split[1] >= 0) && (split[0] >= 0)
            && (split[0] < (Integer.MAX_VALUE / SECONDS_IN_MINUTES))) {
            return split[0] * SECONDS_IN_MINUTES + split[1];
        } else {
            return -1;
        }
    }
}
