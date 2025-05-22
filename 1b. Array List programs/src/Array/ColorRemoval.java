//Write a java program for getting different colors through ArrayList interface and search whether
//the color "Red" is available or not


package Array;

import java.util.ArrayList;

public class ColorRemoval {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Green");
        colors.add("Red");
        colors.add("Yellow");

        if (colors.size() > 1) {
            colors.remove(1); // Remove second element (index 1)
        }
        colors.remove("Blue"); // Remove color "Blue"

        System.out.println("Colors after removal: " + colors);
    }
}
