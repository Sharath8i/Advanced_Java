package String;

public class StringIsNumeric {
    public static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

    public static void main(String[] args) {
        String input = "123456";
        System.out.println("Is numeric? " + isNumeric(input));
    }
}
