package calculator.core;

public class ScientificCalculator {

    public double sin(double x) {
        return Math.sin(Math.toRadians(x));
    }

    public double cos(double x) {
        return Math.cos(Math.toRadians(x));
    }

    public double tan(double x) {
        return Math.tan(Math.toRadians(x));
    }

    public double log(double x) {
        return Math.log10(x);
    }

    public double sqrt(double x) {
        return Math.sqrt(x);
    }

    public double square(double x) {
        return x * x;
    }

    public double reciprocal(double x) {
        if (x == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return 1 / x;
    }
}
