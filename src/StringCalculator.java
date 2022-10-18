import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (hasCustomDelimiter(input)) {
            return sumWithCustomDelimiter(input);
        } else {
            return sumWithDelimiter(input, "[,\\n]");
        }
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private int sumWithCustomDelimiter(String input) {
        var delimiter = input.substring(2, 3);
        return sumWithDelimiter(input.substring(4), delimiter);
    }

    private int sumWithDelimiter(String input, String regex) {
        return Stream.of(input.split(regex))
                .map(Integer::valueOf)
                .reduce(0, Integer::sum);
    }
}