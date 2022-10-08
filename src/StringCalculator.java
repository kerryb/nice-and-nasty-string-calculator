public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else if (input.contains(",")) {
            int index = input.indexOf(",");
            String first = input.substring(0, index);
            String second = input.substring(index + 1);
            return Integer.parseInt(first) + Integer.parseInt(second);
        } else {
            return Integer.parseInt(input);
        }
    }
}