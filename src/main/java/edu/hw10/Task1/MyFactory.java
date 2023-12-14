package edu.hw10.Task1;

public class MyFactory {
    private final String name;
    private final int age;
    private final boolean isMarried;

    private MyFactory(String name, int age, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
    }

    public static MyFactory create(String name, int age, boolean isMarried) {
        return new MyFactory(name, age, isMarried);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return isMarried;
    }
}
