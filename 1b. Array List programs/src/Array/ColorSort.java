//Write a java program for getting different colors through ArrayList interface and sort them
//using Collections.sort( ArrayListObj)


package Array;

import java.util.ArrayList;
import java.util.Collections;

public class ColorSort {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");

        Collections.sort(colors);
        System.out.println("Sorted colors: " + colors);
    }
}

