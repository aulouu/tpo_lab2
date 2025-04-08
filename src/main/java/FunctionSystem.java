import functions.*;

public class FunctionSystem implements MathFunc {
    private static final double EPSILON = 1e-10;

    private final Sin sin;
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Ln ln;
    private final Log log2;
    private final Log log10;
    private final Log log5;

    public FunctionSystem(Sin sin, Cos cos, Tan tan, Cot cot, Ln ln, Log log2, Log log10, Log log5) {
        this.sin = sin;
        this.cos = cos;
        this.tan = tan;
        this.cot = cot;
        this.ln = ln;
        this.log2 = log2;
        this.log10 = log10;
        this.log5 = log5;
    }

    public double calculate(double x, double epsilon) {
        if (x <= 0) {
            if (x == 0) {
                throw new IllegalArgumentException("X can't be 0");
            }
            double sinX = sin.calculate(x, EPSILON);
            double cosX = cos.calculate(x, EPSILON);
            double tanX = tan.calculate(x, EPSILON);
            double cotX = cot.calculate(x, EPSILON);

            double term1 = cotX * cosX;
            double term2 = sinX;
            double term3 = tanX;
            double term4 = cotX * sinX;
            double term5 = Math.pow(cosX, 3);

            return (((term1 + term2) - term3) - term4) + term5;
        } else {
            double lnX = ln.calculate(x, EPSILON);
            double log2X = log2.calculate(x, EPSILON);
            double log10X = log10.calculate(x, EPSILON);
            double log5X = log5.calculate(x, EPSILON);

            double term1 = (log5X * log10X) / log2X;
            double term2 = term1 / log2X;
            double term3 = lnX * lnX;
            double term4 = log10X;
            double term5 = log10X;

            return (term2 - (term3 + term4)) + term5;
        }
    }
}