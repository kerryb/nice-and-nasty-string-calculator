import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    private final StringCalculator calc = new StringCalculator();

    @Test
    public void returnsZeroForEmptyString() {
        assertEquals(0, calc.add(""));
    }

    @Test
    public void returnsTheNumberForASingleNumber() {
        assertEquals(42, calc.add("42"));
    }

    @Test
    public void addsMixedCommaAndNewlineSeparatedNumbers() {
        assertEquals(42, calc.add("20,2\n6,14"));
    }

    @Test
    public void addsNumbersWithCustomDelimiter() {
        assertEquals(42, calc.add("//:\n20:2:6:14"));
    }

    @Test
    public void rejectsNegativeNumbers() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calc.add("42,-2,1,-10"));
        assertEquals("Negatives not allowed: -2, -10", e.getMessage());
    }
}