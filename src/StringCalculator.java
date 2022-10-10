import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (input.startsWith("//")) {
            String delimiter = input.substring(2, 3);
            return Arrays.stream(input.substring(4).split(delimiter))
                    .mapToInt((s) -> Integer.parseInt(s))
                    .sum();
        } else {
            return Arrays.stream(input.split("[,\n]"))
                    .mapToInt((s) -> Integer.parseInt(s))
                    .sum();
        }
    }
}