package edu.hw10.Task1;

public class MyClass {
    @NotNull
    private final String name;
    @Min(0)
    @Max(150)
    private final int age;
    private final boolean isMarried;

    public MyClass(@NotNull String name, @Min(0) @Max(150) int age, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
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
