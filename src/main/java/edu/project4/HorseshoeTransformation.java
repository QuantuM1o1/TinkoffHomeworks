package edu.project4;

public class HorseshoeTransformation implements NonLinearTransformation {
    public HorseshoeTransformation() {
    }

    @Override
    public double getX(double x, double y) {
        double r = 1 / Math.sqrt(x * x + y * y);
        return r * (x - y) * (x + y);
    }

    @Override
    public double getY(double x, double y) {
        double r = 1.0 / Math.sqrt(x * x + y * y);
        return r * 2.0 * x * y;
    }
}
