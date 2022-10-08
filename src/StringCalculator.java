public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (input.contains(",")) {
            String remainingInput = input;
            int sum = 0;
            int index;
            while (remainingInput.contains(",")) {
                index = remainingInput.indexOf(",");
                sum += Integer.parseInt(remainingInput.substring(0, index));
                remainingInput = remainingInput.substring(index + 1);
            }
            return sum + Integer.parseInt(remainingInput);
        } else {
            return Integer.parseInt(input);
        }
    }
}