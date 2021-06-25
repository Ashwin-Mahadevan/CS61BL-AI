import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {

    @Test
    public void testAdd() {
        Measurement m1 = new Measurement(1, 2);
        Measurement m2 = new Measurement(3, 4);

        Measurement sum = m1.plus(m2);

        assertEquals(sum.getFeet(), 4);
        assertEquals(sum.getInches(), 6);
    }

    @Test
    public void testMinus() {
        Measurement m1 = new Measurement(4, 3);
        Measurement m2 = new Measurement(2, 1);

        Measurement diff = m1.minus(m2);

        assertEquals(diff.getFeet(), 2);
        assertEquals(diff.getInches(), 2);
    }

    @Test
    public void testMultiple() {
        Measurement m1 = new Measurement(1, 2);
        Measurement d = m1.multiple(2);
        assertEquals(d.getFeet(), 2);
        assertEquals(d.getInches(), 4);
    }

}