import java.util.Arrays;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (hasCustomDelimiter(input)) {
            return addWithCustomDelimiter(input);
        } else {
            return addWithDefaultDelimiter(input);
        }
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static int addWithCustomDelimiter(String input) {
        String delimiter = input.substring(2, 3);
        String actualInput = input.substring(4);
        return addWithDelimiter(actualInput, delimiter);
    }

    private static int addWithDefaultDelimiter(String input) {
        return addWithDelimiter(input, "[,\n]");
    }

    private static int addWithDelimiter(String input, String regex) {
        return Arrays.stream(input.split(regex)).mapToInt((s) -> Integer.parseInt(s)).sum();
    }
}