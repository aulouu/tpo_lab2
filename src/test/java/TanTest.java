import functions.Cos;
import functions.Sin;
import functions.Tan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TanTest {
    @Test
    public void testCotUsingSinAndCos() {
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);

        when(sinMock.calculate(eq(0.5), anyDouble())).thenReturn(0.479);
        when(cosMock.calculate(eq(0.5), anyDouble())).thenReturn(0.877);

        Tan tan = new Tan(sinMock, cosMock);
        double result = tan.calculate(0.5, 1e-10);

        assertEquals(0.877 / 0.479, result, 1e-6);

        verify(sinMock).calculate(eq(0.5), eq(1e-10));
        verify(cosMock).calculate(eq(0.5), eq(1e-10));
    }
}
