package edu.project4.NonLinearTransformations;

public class SinusoidalTransformation implements NonLinearTransformation {
    public SinusoidalTransformation() {
    }

    @Override
    public double getX(double x, double y) {
        return Math.sin(x);
    }

    @Override
    public double getY(double x, double y) {
        return Math.sin(y);
    }
}
