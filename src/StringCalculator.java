import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else {
            return Stream.of(input.split("[,\\n]"))
                    .map(Integer::valueOf)
                    .reduce(0, Integer::sum);
        }
    }
}