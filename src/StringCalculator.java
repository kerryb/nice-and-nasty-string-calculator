import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else {
            return Arrays.stream(input.split("[,\n]"))
                    .mapToInt((s) -> Integer.parseInt(s))
                    .sum();
        }
    }
}