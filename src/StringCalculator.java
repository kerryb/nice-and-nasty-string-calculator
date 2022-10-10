import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (input.startsWith("//")) {
            String delimiter = input.substring(2, 3);
            return sumWithDelimiter(input.substring(4), delimiter);
        } else {
            return sumWithDelimiter(input, "[,\n]");
        }
    }

    private static int sumWithDelimiter(String input, String regex) {
        return Arrays.stream(input.split(regex))
                .mapToInt((s) -> Integer.parseInt(s))
                .sum();
    }
}