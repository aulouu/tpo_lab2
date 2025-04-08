package functions;

public class Tan implements MathFunc {
    private final Sin sin;
    private final Cos cos;

    public Tan() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public Tan(final Sin sin, final Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double calculate(double x, double epsilon) {
        return sin.calculate(x, epsilon) / cos.calculate(x, epsilon);
    }
}
