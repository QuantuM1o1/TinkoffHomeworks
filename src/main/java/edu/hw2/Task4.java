package edu.hw2;

public class Task4 {
    private Task4() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return new CallingInfo(stackTraceElements[stackTraceElements.length - 1].getClassName(),
            stackTraceElements[stackTraceElements.length - 1].getMethodName());
    }
}
