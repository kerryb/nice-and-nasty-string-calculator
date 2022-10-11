import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        var delimiter = input.substring(2, 3);
        var actualInput = input.substring(4);
        return addWithDelimiter(actualInput, delimiter);
    }

    private static int addWithDefaultDelimiter(String input) {
        return addWithDelimiter(input, "[,\n]");
    }

    private static int addWithDelimiter(String input, String regex) {
        var numbers = Stream.of(input.split(regex)).map(Integer::valueOf).toList();
        validate(numbers);
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.stream().anyMatch((n) -> n < 0)) {
            throw new RuntimeException("Negatives not allowed: " + numbers);
        }
    }
}