package edu.hw2;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        @Override public double evaluate() {
            return value;
        }
    }

    record Negate(Expr obj) implements Expr {
        @Override public double evaluate() {
            return -obj.evaluate();
        }
    }

    record Exponent(Expr base, double power) implements Expr {
        @Override public double evaluate() {
            return Math.pow(base.evaluate(), power);
        }
    }

    record Addition(Expr a, Expr b) implements Expr {
        @Override public double evaluate() {
            return a.evaluate() + b.evaluate();
        }
    }

    record Multiplication(Expr a, Expr b) implements Expr {
        @Override public double evaluate() {
            return a.evaluate() * b.evaluate();
        }
    }
}

