package functions;

public class Cos implements MathFunc {
    private final Sin sin;

    public Cos() {
        this.sin = new Sin();
    }

    public Cos(final Sin sin) {
        this.sin = sin;
    }

    @Override
    public double calculate(double x, double epsilon) {
        return sin.calculate(Math.PI / 2 - x, epsilon);
    }
}
