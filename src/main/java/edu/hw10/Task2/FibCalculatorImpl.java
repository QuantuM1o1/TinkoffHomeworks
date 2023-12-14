package edu.hw10.Task2;

public class FibCalculatorImpl implements FibCalculator {
    @Override
    public long fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
