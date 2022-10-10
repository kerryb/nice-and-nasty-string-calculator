import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (input.startsWith("//")) {
            var delimiter = input.substring(2, 3);
            return Stream.of(input.substring(4).split(delimiter))
                    .map(Integer::valueOf)
                    .reduce(0, Integer::sum);
        } else {
            return Stream.of(input.split("[,\\n]"))
                    .map(Integer::valueOf)
                    .reduce(0, Integer::sum);
        }
    }
}