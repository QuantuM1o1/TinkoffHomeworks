package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private Task1() {
    }

    private static final AtomicInteger COUNTER = new AtomicInteger();

    public static void increment() {
        COUNTER.incrementAndGet();
    }

    public static int value() {
        return COUNTER.get();
    }
}
