package functions;

public class Ln implements MathFunc {
    public double calculate(double x, double epsilon) {
        if (x <= 0) {
            throw new IllegalArgumentException("x must be positive");
        }
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Epsilon must be positive");
        }

        double y = (x - 1) / (x + 1);

        double result = 0;
        double term = y;
        int n = 0;

        while (Math.abs(term) >= epsilon) {
            result += term / (2 * n + 1);
            term = term * y * y;
            n++;
        }

        return 2 * result;
    }
}
