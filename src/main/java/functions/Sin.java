package functions;

public class Sin implements MathFunc {
    public double calculate(double x, double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Epsilon must be positive");
        }

        double result = 0;
        double term = x;
        int n = 1;

        while (Math.abs(term) >= epsilon) {
            result += term;
            term = -term * x * x / ((2 * n) * (2 * n + 1));
            n++;
        }

        return result;
    }
}
