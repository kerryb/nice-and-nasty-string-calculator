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
                String first = input.substring(0, index);
                String second = input.substring(index + 1);
                try {
                    return Integer.parseInt(first) + Integer.parseInt(second);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Input is invalid");
                }
            }
        }
    }
}
