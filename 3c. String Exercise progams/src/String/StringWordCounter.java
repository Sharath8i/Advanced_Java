//
//Q10. Write a Java Program for Counting the number of words in a string using user defined function countWords()


package String;

public class StringWordCounter {
    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) return 0;
        return input.trim().split("\\s+").length;
    }

    public static void main(String[] args) {
        String input = "Count the number of words in this string.";
        System.out.println("Word count: " + countWords(input));
    }
}
