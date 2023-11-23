package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {
    private Task2() {
    }

    private static final long MAX_NUM = 20L;

    private final static Logger LOGGER = LogManager.getLogger();

    public static long factorial(long number) {
        if (number < 0 || number > MAX_NUM) {
            LOGGER.info("Number is either too big, or less than 0");
            return -1L;
        }
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= number; i++) {
            list.add(i);
        }
        return list.parallelStream().reduce(1L, (x, y) -> x * y);
    }
}
