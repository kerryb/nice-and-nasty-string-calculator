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