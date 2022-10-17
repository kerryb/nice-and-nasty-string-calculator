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
    public void addsTwoCommaSeparatedNumbers() {
        assertEquals(42, calc.add("40,2"));
    }

    @Test
    public void addsMultipleCommaSeparatedNumbers() {
        assertEquals(42, calc.add("20,2,14,6"));
    }

    @Test
    public void addsNewlineAndCommaSeparatedNumbers() {
        assertEquals(42, calc.add("20\n2,6\n14"));
    }

    @Test
    public void addsNumbersWithCustomDelimiter() {
        assertEquals(42, calc.add("//:\n20:2:6:14"));
    }

    @Test
    public void rejectsNegativeNumbers() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calc.add("42,-2\n-10,1"));
        assertEquals("Negatives not allowed: -2, -10", e.getMessage());
    }

    @Test
    public void rejectsNegativeNumbersIncludingTheLastOne() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calc.add("42,-2,-10,-1"));
        assertEquals("Negatives not allowed: -2, -10, -1", e.getMessage());
    }

    @Test
    public void rejectsNegativeNumbersIncludingTheLastOneWithCustomDelimiter() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calc.add("//:\n42:-2:-10:-1"));
        assertEquals("Negatives not allowed: -2, -10, -1", e.getMessage());
    }
}