package edu.hw8.Task2;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class FixedThreadPool implements ThreadPool, AutoCloseable {
    private final Thread[] threads;
    private final Queue<Runnable> queue;

    private FixedThreadPool(int numberOfThreads) {
        threads = new Thread[numberOfThreads];
        queue = new ConcurrentLinkedDeque<>();
    }

    public static FixedThreadPool create(int numberOfThreads) {
        return new FixedThreadPool(numberOfThreads);
    }

    @Override
    public void start() {
        Arrays.setAll(threads, i -> new Thread(() -> {
            while (!queue.isEmpty()) {
                Runnable task = queue.poll();
                task.run();
            }
        }));
        Arrays.stream(threads).forEach(Thread::start);
    }

    @Override
    public void execute(Runnable runnable) {
        queue.add(runnable);
    }

    @Override
    public void close() {
        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Pool wasn't closed correctly");
            }
        });
    }
}
