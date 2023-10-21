package edu.hw2.Task2;

public class Rectangle {
    protected int width;
    protected int height;

    Rectangle setWidth(int width) {
        this.width = width;
        return this;
    }

    Rectangle setHeight(int height) {
        this.height = height;
        return this;
    }

    double area() {
        return width * height;
    }
}
