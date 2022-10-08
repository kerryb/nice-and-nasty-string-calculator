public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Input is invalid");
            }
        }
    }
}
