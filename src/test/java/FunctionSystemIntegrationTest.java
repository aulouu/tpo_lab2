import functions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FunctionSystemIntegrationTest {
    @Test
    public void testFunctionSystemForXLessThanOrEqualToZero() {
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);
        Tan tanMock = mock(Tan.class);
        Cot cotMock = mock(Cot.class);
        Ln lnMock = mock(Ln.class);
        Log log2Mock = mock(Log.class);
        Log log5Mock = mock(Log.class);
        Log log10Mock = mock(Log.class);

        when(sinMock.calculate(eq(-1.0), anyDouble())).thenReturn(-0.8415);
        when(cosMock.calculate(eq(-1.0), anyDouble())).thenReturn(0.5403);
        when(tanMock.calculate(eq(-1.0), anyDouble())).thenReturn(-1.5574);
        when(cotMock.calculate(eq(-1.0), anyDouble())).thenReturn(-0.6421);

        FunctionSystem functionSystem = new FunctionSystem(
                sinMock, cosMock, tanMock, cotMock, lnMock, log2Mock, log10Mock, log5Mock
        );

        double result = functionSystem.calculate(-1.0, 1e-10);

        // Расчет ожидаемого значения вручную:
        // cot(-1)*cos(-1) = -0.6421*0.5403 ≈ -0.3469
        // + sin(-1) = -0.3469 + (-0.8415) ≈ -1.1884
        // - tan(-1) = -1.1884 - (-1.5574) ≈ 0.3690
        // - cot(-1)*sin(-1) = 0.3690 - (-0.6421*-0.8415) ≈ 0.3690 - 0.5403 ≈ -0.1713
        // + cos(-1)^3 = -0.1713 + (0.5403^3) ≈ -0.1713 + 0.1577 ≈ -0.0136
        double expected = -0.0136;

        assertEquals(expected, result, 1e-4);
    }

    @Test
    public void testFunctionSystemForXGreaterThanZero() {
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);
        Tan tanMock = mock(Tan.class);
        Cot cotMock = mock(Cot.class);
        Ln lnMock = mock(Ln.class);
        Log log2Mock = mock(Log.class);
        Log log10Mock = mock(Log.class);
        Log log5Mock = mock(Log.class);

        when(lnMock.calculate(eq(2.0), anyDouble())).thenReturn(0.6931);
        when(log2Mock.calculate(eq(2.0), anyDouble())).thenReturn(1.0);
        when(log10Mock.calculate(eq(2.0), anyDouble())).thenReturn(0.3010);
        when(log5Mock.calculate(eq(2.0), anyDouble())).thenReturn(0.4307);

        FunctionSystem functionSystem = new FunctionSystem(
                sinMock, cosMock, tanMock, cotMock, lnMock, log2Mock, log10Mock, log5Mock
        );

        double result = functionSystem.calculate(2.0, 1e-10);

        // Расчет ожидаемого значения вручную:
        // log5(2)*log10(2) = 0.4307*0.3010 ≈ 0.1296
        // / log2(2) = 0.1296 / 1.0 ≈ 0.1296
        // / log2(2) = 0.1296 / 1.0 ≈ 0.1296
        // - (ln(2)*ln(2) = 0.1296 - (0.6931*0.6931) ≈ 0.1296 - 0.4804 ≈ -0.3508
        // - log10(2) = -0.3508 - 0.3010 ≈ -0.6518
        // + log10(2) = -0.6518 + 0.3010 ≈ -0.3508
        double expected = -0.3508;

        assertEquals(expected, result, 1e-4);
    }
}
