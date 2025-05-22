//Write a Java Program for Eliminating all whitespace characters from a string using user defined function removeWhitespace()


package String;

public class StringRemoveWhitespace {
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        String input = "  Java   Programming   Language ";
        System.out.println("Without whitespace: " + removeWhitespace(input));
    }
}
