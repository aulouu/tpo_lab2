import functions.Sin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinTest {

    private static final double EPSILON = 1e-10;

    @Test
    public void testSinZero() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.calculate(0, EPSILON), 1e-6);
    }

    @Test
    public void testSinPiDivTwo() {
        Sin sin = new Sin();
        assertEquals(1.0, sin.calculate(Math.PI / 2, EPSILON), 1e-6);
    }

    @Test
    public void testSinPi() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.calculate(Math.PI, EPSILON), 1e-6);
    }

    @Test
    public void testSinInvalidEpsilon() {
        Sin sin = new Sin();
        assertThrows(IllegalArgumentException.class, () -> sin.calculate(0, -1));
    }
}
