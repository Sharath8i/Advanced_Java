//Write a Java program that swaps two elements ( first and third elements ) in a linked list ( using Collections.swap(l_list, 0, 2))


package LinkedList;

import java.util.*;

public class SwapElementsInList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));

        System.out.println("Before swap: " + list);
        Collections.swap(list, 0, 2); // Swap 1st and 3rd elements (index 0 and 2)
        System.out.println("After swap: " + list);
    }
}

