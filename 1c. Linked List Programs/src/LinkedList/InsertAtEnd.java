//Write a Java program to insert the specified element at the end of a linked list.( using l_listobj.offerLast("Pink"))


package LinkedList;

import java.util.*;

public class InsertAtEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Green", "Blue"));

        list.offerLast("Pink"); // Insert at end
        System.out.println("List after adding element at the end:");
        System.out.println(list);
    }
}
