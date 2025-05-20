/* Author: Hayley So
 * Description: ArrayList Formative Quiz
 * Purpose: To test my understanding of ArrayLists
 * Date: 10/18/2024
 * JDK version: 22.02
 */

 // Marking Scheme        Program               12/12A
 //                       Short Answer          5/5K

import java.util.Scanner;

import java.util.ArrayList; //Import library

public class ArrayList_Teach_Quiz {

  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);

    // Arraylist with a type declaration

    // Declare an arrayList called a1 that can store items Quiz   12/12A

    ArrayList<String> a1 = new ArrayList<String>(); // Generic declaration    2/2

    String input;

    // Fill in the answers for the blanks below

    System.out.println("Initial size of a1 after declaration is: " + a1.size()); // Output would be 0   1/1
    System.out.println("Press a key to continue");
    input = kb.nextLine();

    // Adding items to the arraylist
    a1.add("C");// position 0
    a1.add("A");// 1
    a1.add("E");// 2
    a1.add("B");// 3
    a1.add("D");
    a1.add("F");
    
    // Inserting an item A2 in the 2nd position of the array (in between C and A)
    a1.add(1, "A2"); //  2/2

    System.out.println("Size of a1 after adding 7 items  is: " + a1.size()); // Output would be 7   2/2
    System.out.println("Press a key to continue");
    input = kb.nextLine();

    System.out.println("The contents of a1 is: " + a1); // Output would be [C, A2, A, E, B, D, F]   2/2
    System.out.println("Press a key to continue");
    input = kb.nextLine();

    // Remove elements from the array
    a1.remove("F");
    a1.remove(2);

    System.out.println("Size of a1 after  deletions  is: " + a1.size()); // Output would be 5   1/1
    System.out.println("Press a key to continue");
    input = kb.nextLine();

    System.out.println("The contents of a1 after removing F and the 2nd item is: " + a1); // Output would be [C, A2, E, B, D]   2/2
                                                                                        
    System.out.println("Press a key to continue");
    input = kb.nextLine();

    kb.close();

    // Pros of an ArrayList
    // 1. ArrayLists are dynamic in size, meaning that they can grow or shrink in size
    // 2. ArrayLists are more flexible and can change length while the program is running
    // 3. ArrayLists have built-in methods that make it easier to manipulate the data stored in them

    // Cons of an ArrayList
    // 1. ArrayLists are slightly slower than arrays due to memory demands
    // 2. ArrayLists can only store objects, not primitive data types

  }
}