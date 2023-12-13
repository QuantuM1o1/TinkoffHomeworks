package edu.project4.Image;

public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int hitCount;
    private double normal;

    public Pixel() {
        red = 0;
        green = 0;
        blue = 0;
        hitCount = 0;
        normal = 0;
    }

    public synchronized void incrementHitCount() {
        hitCount++;
    }

    public synchronized int getHitCount() {
        return hitCount;
    }

    public synchronized int getRed() {
        return red;
    }

    public synchronized void setRed(int red) {
        this.red = red;
    }

    public synchronized int getGreen() {
        return green;
    }

    public synchronized void setGreen(int green) {
        this.green = green;
    }

    public synchronized int getBlue() {
        return blue;
    }

    public synchronized void setBlue(int blue) {
        this.blue = blue;
    }

    public synchronized double getNormal() {
        return normal;
    }

    public synchronized void setNormal(double normal) {
        this.normal = normal;
    }
}
