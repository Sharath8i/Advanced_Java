package String;

public class StringCapitalizeWords {
    public static String capitalizeWords(String input) {
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty())
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String input = "java string manipulation example";
        System.out.println("Capitalized: " + capitalizeWords(input));
    }
}
