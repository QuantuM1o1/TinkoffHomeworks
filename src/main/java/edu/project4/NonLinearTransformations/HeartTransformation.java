package edu.project4.NonLinearTransformations;

public class HeartTransformation implements NonLinearTransformation {
    public HeartTransformation() {
    }

    @Override
    public double getX(double x, double y) {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return r * Math.sin(theta * r);
    }

    @Override
    public double getY(double x, double y) {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return -r * Math.cos(theta * r);
    }
}
