import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String input) {
        String remainingInput;
        if (input.isEmpty()) {
            return 0;
        } else if (input.startsWith("//")) {
            String delimiter = input.substring(2, 3);
            remainingInput = input.substring(4);
            int sum = 0;
            List<Integer> invalid = new ArrayList<Integer>();
            while (remainingInput.contains(delimiter)) {
                int index = remainingInput.indexOf(delimiter);
                int number = Integer.parseInt(remainingInput.substring(0, index));
                if (number < 1) {
                    invalid.add(number);
                }
                sum += number;
                remainingInput = remainingInput.substring(index + 1);
            }
            int remainingNumber = Integer.parseInt(remainingInput);
            if (remainingNumber < 1) {
                invalid.add(remainingNumber);
            }
            if (!invalid.isEmpty()) {
                StringBuilder message = new StringBuilder("Negatives not allowed: ");
                for (int i = 0; i < invalid.size(); i++) {
                    if (i > 0) {
                        message.append(", ");
                    }
                    message.append(invalid.get(i));
                }
                throw new RuntimeException(message.toString());
            }
            return sum + remainingNumber;
        } else {
            int index = input.indexOf(",");
            if (index == -1) {
                try {
                    int number = Integer.parseInt(input);
                    if (number < 0) {
                        throw new RuntimeException("Negatives not allowed: " + number);
                    }
                    return number;
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Input is invalid");
                }
            } else {
                try {
                    remainingInput = input;
                    int sum = 0;
                    int commaIndex, newlineIndex;
                    List<Integer> invalid = new ArrayList<Integer>();
                    while (remainingInput.contains(",") || remainingInput.contains("\n")) {
                        commaIndex = remainingInput.indexOf(",");
                        newlineIndex = remainingInput.indexOf("\n");
                        if (newlineIndex == -1 || commaIndex != -1 && commaIndex < newlineIndex) {
                            int number = Integer.parseInt(remainingInput.substring(0, commaIndex));
                            if (number < 1) {
                                invalid.add(number);
                            }
                            sum += number;
                            remainingInput = remainingInput.substring(commaIndex + 1);
                        } else {
                            int number = Integer.parseInt(remainingInput.substring(0, newlineIndex));
                            if (number < 1) {
                                invalid.add(number);
                            }
                            sum += number;
                            remainingInput = remainingInput.substring(newlineIndex + 1);
                        }
                    }
                    int remainingNumber = Integer.parseInt(remainingInput);
                    if (remainingNumber < 1) {
                        invalid.add(remainingNumber);
                    }
                    if (!invalid.isEmpty()) {
                        StringBuilder message = new StringBuilder("Negatives not allowed: ");
                        for (int i = 0; i < invalid.size(); i++) {
                            if (i > 0) {
                                message.append(", ");
                            }
                            message.append(invalid.get(i));
                        }
                        throw new RuntimeException(message.toString());
                    }
                    return sum + remainingNumber;
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Input is invalid");
                }
            }
        }
    }
}
