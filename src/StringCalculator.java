import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int[] numbers = Arrays.stream(input.split(regex)).mapToInt(Integer::parseInt).toArray();
        validate(numbers);
        return Arrays.stream(numbers).sum();
    }

    private static void validate(int[] numbers) {
        int[] negatives = Arrays.stream(numbers).filter((n) -> n < 0).toArray();
        if (negatives.length > 0) {
            throw new RuntimeException("Negatives not allowed: " + Arrays.stream(negatives)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(", ")));
        }
    }
}