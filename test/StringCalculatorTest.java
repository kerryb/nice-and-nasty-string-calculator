import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void addsTwoCommaSeparatedNumbers() {
        assertEquals(42, calc.add("40,2"));
    }

    @Test
    public void addsMultipleCommaSeparatedNumbers() {
        assertEquals(42, calc.add("20,2,14,6"));
    }
}