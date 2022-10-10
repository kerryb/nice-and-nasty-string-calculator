import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private final StringCalculator calc = new StringCalculator();

    @Test
    void returnsZeroForEmptyString() {
        assertEquals(0, calc.add(""));
    }

    @Test
    void returnsTheNumberForASingleNumber() {
        assertEquals(42, calc.add("42"));
    }

    @Test
    void addsCommaSeparatedNumbers() {
        assertEquals(42, calc.add("20,2,6,14"));
    }

    @Test
    void addsNewlineSeparatedNumbers() {
        assertEquals(42, calc.add("20\n2\n6\n14"));
    }

    @Test
    void addsMixedCommaAndNewlineSeparatedNumbers() {
        assertEquals(42, calc.add("20,2\n6,14"));
    }

    @Test
    void addsNumbersWithCustomDelimiter() {
        assertEquals(42, calc.add("//:\n20:2:6:14"));
    }
}