public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else {
            throw new RuntimeException("Input is invalid");
        }
    }
}
