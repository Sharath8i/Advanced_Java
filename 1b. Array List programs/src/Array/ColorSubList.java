//Write a java program for getting different colors through ArrayList interface and extract the
//elements 1st and 2nd from the ArrayList object by using SubList()


package Array;

import java.util.ArrayList;
import java.util.List;

public class ColorSubList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");

        List<String> subColors = colors.subList(0, 2); // Extract elements at index 0 and 1
        System.out.println("First two colors: " + subColors);
    }
}

