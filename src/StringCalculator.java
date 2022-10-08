public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (input.contains(",") || input.contains("\n")) {
            String remainingInput = input;
            int sum = 0;
            int commaIndex, newlineIndex, index;
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
                sum += Integer.parseInt(remainingInput.substring(0, index));
                remainingInput = remainingInput.substring(index + 1);
            }
            return sum + Integer.parseInt(remainingInput);
        } else {
            return Integer.parseInt(input);
        }
    }
}