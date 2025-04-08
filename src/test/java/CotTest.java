import functions.Cos;
import functions.Cot;
import functions.Sin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CotTest {
    @Test
    public void testCotUsingSinAndCos() {
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);

        when(sinMock.calculate(eq(0.5), anyDouble())).thenReturn(0.479);
        when(cosMock.calculate(eq(0.5), anyDouble())).thenReturn(0.877);

        Cot cot = new Cot(sinMock, cosMock);
        double result = cot.calculate(0.5, 1e-10);

        assertEquals(0.479 / 0.877, result, 1e-6);

        verify(sinMock).calculate(eq(0.5), eq(1e-10));
        verify(cosMock).calculate(eq(0.5), eq(1e-10));
    }
}
