package String;

public class StringReverse {
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        String input = "JavaProgramming";
        System.out.println("Reversed string: " + reverseString(input));
    }
}
