import functions.Cos;
import functions.Sin;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;

public class CosTest {
    @Test
    public void testCosUsingSin() {
        Sin sinMock = Mockito.mock(Sin.class);

        Mockito.when(sinMock.calculate(eq(Math.PI / 2 - 0.5), eq(1e-10))).thenReturn(0.877583);

        Cos cos = new Cos(sinMock);
        double result = cos.calculate(0.5, 1e-10);

        assertEquals(0.877583, result, 1e-6);
        verify(sinMock).calculate(eq(Math.PI / 2 - 0.5), eq(1e-10));
    }
}
