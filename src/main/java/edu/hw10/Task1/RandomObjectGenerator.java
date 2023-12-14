package edu.hw10.Task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomObjectGenerator {
    private final Random random;
    private static final double NULL_PROBABILITY = 0.5;
    public static final int MAX_LENGTH_OF_STRING = 8;
    public static final int NUMBER_OF_LATIN_LETTERS = 26;
    public static final String ILLEGAL_ACCESS_MESSAGE = "Class should have public constructor";
    public static final String INVOCATION_TARGET_MESSAGE = "Constructor threw an exception";

    public RandomObjectGenerator() {
        this.random = ThreadLocalRandom.current();
    }

    public <T> T nextObject(Class<T> tClass) {
        Constructor<?>[] constructors = tClass.getConstructors();
        if (constructors.length == 0) {
            throw new RuntimeException("Class doesn't have constructors");
        }
        Constructor<T> constructor = (Constructor<T>) constructors[0];
        Parameter[] parameters = constructor.getParameters();
        Object[] args = new Object[parameters.length];
        for (int i = 0; i < args.length; i++) {
            args[i] = getRandomValue(parameters[i]);
        }
        try {
            return constructor.newInstance(args);
        } catch (InstantiationException e) {
            throw new RuntimeException("Class shouldn't be abstract");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(ILLEGAL_ACCESS_MESSAGE);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(INVOCATION_TARGET_MESSAGE);
        }
    }

    public <T> T nextObject(Class<T> tClass, String factoryName) {
        Method factoryMethod = findFactoryMethod(tClass, factoryName);
        Parameter[] parameters = factoryMethod.getParameters();
        Object[] args = new Object[parameters.length];
        for (int i = 0; i < args.length; i++) {
            args[i] = getRandomValue(parameters[i]);
        }
        try {
            return (T) factoryMethod.invoke(null, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(ILLEGAL_ACCESS_MESSAGE);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(INVOCATION_TARGET_MESSAGE);
        }
    }

    private Object getRandomValue(Parameter parameter) {
        boolean isNotNull = false;
        double min = Double.NEGATIVE_INFINITY;
        double max = Double.POSITIVE_INFINITY;
        Class<?> type = parameter.getType();
        Annotation[] annotations = parameter.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof NotNull) {
                isNotNull = true;
            }
            if (annotation instanceof Min) {
                min = ((Min) annotation).value();
            }
            if (annotation instanceof Max) {
                max = ((Max) annotation).value();
            }
        }
        if (random.nextDouble() < NULL_PROBABILITY && !type.isPrimitive() && !isNotNull) {
            return null;
        }
        return switch (type.getSimpleName()) {
            case "int", "Integer" -> getRandomInt(min, max);
            case "double", "Double" -> getRandomDouble(min, max);
            case "float", "Float" -> getRandomFloat(min, max);
            case "long", "Long" -> getRandomLong(min, max);
            case "boolean", "Boolean" -> random.nextBoolean();
            case "String" -> getRandomString();
            default -> throw new RuntimeException("Unsupported type: " + type.getName());
        };
    }

    private int getRandomInt(double min, double max) {
        return random.nextInt((int) min, (int) max);
    }

    private double getRandomDouble(double min, double max) {
        return random.nextDouble(min, max);
    }

    private float getRandomFloat(double min, double max) {
        return random.nextFloat((float) min, (float) max);
    }

    private long getRandomLong(double min, double max) {
        return random.nextLong((long) min, (long) max);
    }

    private String getRandomString() {
        int length = random.nextInt(1, MAX_LENGTH_OF_STRING);
        StringBuilder stringBuilder = new StringBuilder();
        char randomChar = (char) (random.nextInt(NUMBER_OF_LATIN_LETTERS) + 'A');
        stringBuilder.append(randomChar);
        for (int i = 1; i < length; i++) {
            randomChar = (char) (random.nextInt(NUMBER_OF_LATIN_LETTERS) + 'a');
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    private Method findFactoryMethod(Class<?> tClass, String factoryName) {
        Method[] methods = tClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(factoryName) && method.getReturnType().equals(tClass)) {
                return method;
            }
        }
        throw new RuntimeException("Factory method with this name: " + factoryName + " doesn't exist");
    }
}
