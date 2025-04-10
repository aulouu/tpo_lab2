import functions.MathFunc;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private static final double EPSILON = 1e-10;

    public CsvWriter() {
    }

    public void writeResults(String filename, double start, double end, MathFunc func, double step) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("X,Result\n");

            for (double x = start; x <= end; x += step) {
                double result = func.calculate(x, EPSILON);
                if (Double.isNaN(result)) {
                    continue;
                }
                writer.write(x + "," + result + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
