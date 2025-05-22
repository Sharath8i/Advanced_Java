package Array;

import java.util.ArrayList;

public class ColorRemoveNt {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");

        int n = 2; // Remove 3rd element, i.e., index 2
        if (n < colors.size()) {
            colors.remove(n);
        }

        System.out.println("Colors after removing nth element: " + colors);
    }
}

