import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String input) {
        String remainingInput;
        int sum = 0;
        int commaIndex, newlineIndex, index;

        if (input.isEmpty()) {
            return 0;
        } else if (input.startsWith("//")) {
            String delimiter = input.substring(2, 3);
            remainingInput = input.substring(4);
            while (remainingInput.contains(delimiter)) {
                index = remainingInput.indexOf(delimiter);
                sum += Integer.parseInt(remainingInput.substring(0, index));
                remainingInput = remainingInput.substring(index + 1);
            }
            return sum + Integer.parseInt(remainingInput);
        } else if (input.contains(",") || input.contains("\n")) {
            remainingInput = input;
            List<Integer> invalid = new ArrayList<>();
            while (remainingInput.contains(",") || remainingInput.contains("\n")) {
                commaIndex = remainingInput.indexOf(",");
                newlineIndex = remainingInput.indexOf("\n");
                if (commaIndex == -1) {
                    index = newlineIndex;
                } else if (newlineIndex == -1) {
                    index = commaIndex;
                } else {
                    index = Integer.min(commaIndex, newlineIndex);
                }
                int number = Integer.parseInt(remainingInput.substring(0, index));
                if (number < 0) {
                    invalid.add(number);
                } else {
                    sum += number;
                }
                remainingInput = remainingInput.substring(index + 1);
            }
            int lastNumber = Integer.parseInt(remainingInput);
            if (lastNumber < 0) {
                invalid.add(lastNumber);
            }
            if (invalid.isEmpty()) {
                return sum + lastNumber;
            } else {
                StringBuilder message = new StringBuilder("Negatives not allowed: ");
                for (int i = 0; i < invalid.size(); i++) {
                    if (i > 0) {
                        message.append(", ");
                    }
                    message.append(invalid.get(i));
                }
                throw new RuntimeException(message.toString());
            }
        } else {
            return Integer.parseInt(input);
        }
    }
}