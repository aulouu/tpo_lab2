import functions.Ln;
import functions.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LogTest {
    @Test
    public void testLogUsingLn() {
        Ln lnMock = mock(Ln.class);

        when(lnMock.calculate(eq(2.0), anyDouble())).thenReturn(0.693);
        when(lnMock.calculate(eq(8.0), anyDouble())).thenReturn(2.079);

        Log log2 = new Log(lnMock, 2);
        double result = log2.calculate(8.0, 1e-10);
        assertEquals(3, result, 1e-6);

        verify(lnMock).calculate(eq(8.0), eq(1e-10));
        verify(lnMock).calculate(eq(2.0), eq(1e-10));
    }
}
