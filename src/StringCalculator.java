public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else {
            int index = input.indexOf(",");
            if (index == -1) {
                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Input is invalid");
                }
            } else {
                try {
                    String remainingInput = input;
                    int sum = 0;
                    int commaIndex, newlineIndex;
                    while (remainingInput.contains(",") || remainingInput.contains("\n")) {
                        commaIndex = remainingInput.indexOf(",");
                        newlineIndex = remainingInput.indexOf("\n");
                        if (newlineIndex == -1 || commaIndex != -1 && commaIndex < newlineIndex) {
                            sum += Integer.parseInt(remainingInput.substring(0, commaIndex));
                            remainingInput = remainingInput.substring(commaIndex + 1);
                        } else {
                            sum += Integer.parseInt(remainingInput.substring(0, newlineIndex));
                            remainingInput = remainingInput.substring(newlineIndex + 1);
                        }
                    }
                    return sum + Integer.parseInt(remainingInput);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Input is invalid");
                }
            }
        }
    }
}
