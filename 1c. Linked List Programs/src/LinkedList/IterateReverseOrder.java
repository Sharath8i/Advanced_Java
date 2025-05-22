//Write a Java program to iterate a linked list in reverse order (using objlist.descendingIterator())


package LinkedList;

import java.util.*;

public class IterateReverseOrder {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));

        Iterator<String> iterator = list.descendingIterator();
        System.out.println("Iterating in reverse order:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

