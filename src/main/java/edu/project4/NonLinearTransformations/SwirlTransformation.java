package edu.project4.NonLinearTransformations;

public class SwirlTransformation implements NonLinearTransformation {
    public SwirlTransformation() {
    }

    @Override
    public double getX(double x, double y) {
        double r = x * x + y * y;
        return x * Math.sin(r) - y * Math.cos(r);
    }

    @Override
    public double getY(double x, double y) {
        double r = x * x + y * y;
        return x * Math.cos(r) - y * Math.sin(r);
    }
}
