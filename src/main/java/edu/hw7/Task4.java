package edu.hw7;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.Stream;

public class Task4 {
    private static final double COEFFICIENT = 4D;

    private Task4() {
    }

    public static double singleThreadPi(int number) {
        double totalCount = 0;
        double circleCount = 0;
        Random random = ThreadLocalRandom.current();
        for (int i = 0; i < number; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y < 1D) {
                circleCount++;
            }
            totalCount++;
        }
        return COEFFICIENT * (circleCount / totalCount);
    }

    public static double multipleThreadsPi(int number, int numberOfThreads) {
        DoubleAdder totalCount = new DoubleAdder();
        DoubleAdder circleCount = new DoubleAdder();
        List<Thread> threads = Stream.generate(() -> new Thread(() -> {
            Random random = ThreadLocalRandom.current();
            double totalCurrentCount = 0D;
            double circleCurrentCount = 0D;
            for (int i = 0; i < number / numberOfThreads; i++) {
                double x = random.nextDouble();
                double y = random.nextDouble();
                if (x * x + y * y < 1D) {
                    circleCurrentCount++;
                }
                totalCurrentCount++;
            }
            totalCount.add(totalCurrentCount);
            circleCount.add(circleCurrentCount);
        })).limit(numberOfThreads).toList();
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return COEFFICIENT * (circleCount.sum() / totalCount.sum());
    }
}
