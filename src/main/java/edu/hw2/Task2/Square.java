package edu.hw2.Task2;

public class Square extends Rectangle {
    @Override
    Rectangle setWidth(int width) {
        if (this.height == 0) {
            this.width = width;
            this.height = width;
            return this;
        } else if (this.height == width) {
            return this;
        } else {
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(width);
            rectangle.setHeight(this.height);
            return rectangle;
        }
    }

    @Override
    Rectangle setHeight(int height) {
        if (this.width == 0) {
            this.width = height;
            this.height = height;
            return this;
        } else if (this.width == height) {
            return this;
        } else {
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(this.width);
            rectangle.setHeight(height);
            return rectangle;
        }
    }

    Square setSide(int side) {
        this.width = side;
        this.height = side;
        return this;
    }
}
