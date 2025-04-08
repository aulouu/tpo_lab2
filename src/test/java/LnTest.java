import functions.Ln;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {

    private static final double EPSILON = 1e-10;

    @Test
    public void testLnOne() {
        Ln ln = new Ln();
        assertEquals(0.0, ln.calculate(1, EPSILON), 1e-6);
    }

    @Test
    public void testLnE() {
        Ln ln = new Ln();
        assertEquals(1.0, ln.calculate(Math.E, EPSILON), 1e-6);
    }

    @Test
    public void testLnLessThanOne() {
        Ln ln = new Ln();
        assertEquals(-Math.log(2), ln.calculate(0.5, EPSILON), 1e-6);
    }

    @Test
    public void testLnGreaterThanOne() {
        Ln ln = new Ln();
        assertEquals(Math.log(2), ln.calculate(2, EPSILON), 1e-6);
    }

    @Test
    public void testLnZero() {
        Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(0, EPSILON));
    }

    @Test
    public void testLnNegative() {
        Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(-1, EPSILON));
    }

    @Test
    public void testLnInvalidEpsilon() {
        Ln ln = new Ln();
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(1, -1));
    }
}
