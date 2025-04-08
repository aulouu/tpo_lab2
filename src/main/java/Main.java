import functions.*;

public class Main {
    public static void main(String[] args) {
        // Создание зависимостей
        Sin sin = new Sin();
        Cos cos = new Cos();
        Tan tan = new Tan(sin, cos);
        Cot cot = new Cot(sin, cos);
        Ln ln = new Ln();
        Log log2 = new Log(2);
        Log log10 = new Log(10);
        Log log5 = new Log(5);

        // Создание системы функций
        FunctionSystem functionSystem = new FunctionSystem(sin, cos, tan, cot, ln, log2, log10, log5);

        // Пример вычисления
        double result = functionSystem.calculate(-1.0, 1e-10);
        System.out.println("Result: " + result);

        CsvWriter csvWriter = new CsvWriter();
        csvWriter.writeResults("sin.scv", -5, 5, sin, 0.1);
        csvWriter.writeResults("cos.scv", -5, 5, cos, 0.1);
        csvWriter.writeResults("tan.scv", -5, 5, tan, 0.1);
        csvWriter.writeResults("cot.scv", -5, 5, cot, 0.1);
        csvWriter.writeResults("ln.scv", 0.00001, 5, ln, 0.1);
        csvWriter.writeResults("log2.scv", 0.00001, 5, log2, 0.1);
        csvWriter.writeResults("system.scv", -5, 5, functionSystem, 0.1);
    }
}
