package functions;

public class Log implements MathFunc {
    private final Ln ln;
    private final double base;

    public Log(double base) {
        this.ln = new Ln();
        this.base = base;
    }

    public Log(final Ln ln, double base) {
        this.ln = ln;
        this.base = base;
    }

    public double calculate(double x, double epsilon) {
        if (this.base == 1 || this.base <= 0) {
            throw new IllegalArgumentException("Base must be greater than zero and not equal to 1");
        }
        return ln.calculate(x, epsilon) / ln.calculate(base, epsilon);
    }
}
