package edu.project4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AffineTransformation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private final int red;
    private final int green;
    private final int blue;

    private static final int EIGHT_BITS_COLOUR = 255;

    public AffineTransformation() {
        Random random = ThreadLocalRandom.current();
        do {
            a = random.nextDouble();
            b = random.nextDouble();
            c = random.nextDouble();
            d = random.nextDouble();
            e = random.nextDouble();
            f = random.nextDouble();
        } while (a * a + d * d >= 1
            || b * b + e * e >= 1
            || a * a + b * b + d * d + e * e >= 1 + (a * e - b * d) * (a * e - b * d));
        if ((random.nextInt() & 1) == 0) {
            a = -a;
        }
        if ((random.nextInt() & 1) == 0) {
            b = -b;
        }
        if ((random.nextInt() & 1) == 0) {
            c = -c;
        }
        if ((random.nextInt() & 1) == 0) {
            d = -d;
        }
        if ((random.nextInt() & 1) == 0) {
            e = -e;
        }
        if ((random.nextInt() & 1) == 0) {
            f = -f;
        }
        red = random.nextInt(EIGHT_BITS_COLOUR);
        green = random.nextInt(EIGHT_BITS_COLOUR);
        blue = random.nextInt(EIGHT_BITS_COLOUR);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
