package functions;

public class Cot implements MathFunc {
    private final Sin sin;
    private final Cos cos;

    public Cot() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public Cot(final Sin sin, final Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double calculate(double x, double epsilon) {
        return cos.calculate(x, epsilon) / sin.calculate(x, epsilon);
    }
}
