/* Author: Hayley So
 * Date: 11/07/2024
 * JDK version: 22.0.2
 * Description: This programs prompts the uesr to enter 5 names and their corresponding phone numbers.
 *              It then asks the user to search for a name in the array and choose between iterative
 *              and recursive binary search methods to find the name.
 */

import java.util.Scanner; // import Scanner class
import java.util.Calendar; // import Calendar class

public class SearchingExercise1 {

    static Scanner sc = new Scanner(System.in); // create Scanner object
    static final int SIZE = 5; // create constant variable to store the size of the two arrays

    /**
     * Main method that executes the program
     * 
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        // create two arrays to store the names and phone numbers of the people
        String[] name = new String[SIZE];
        String[] phoneNumber = new String[SIZE];
        // intialize variables to store the start, end time, and running time of the search
        long startTime, endTime, runningTime;
        // boolean variable to store if the name is found in the array
        boolean found;
        // boolean variable to store if the user wants to repeat the search
        boolean repeat = true;

        // prompt the user to enter the names and phone numbers of 5 people
        System.out.println("Please enter the names and phone numbers of 5 people.");
        System.out.println();
        for (int i = 0; i < name.length; i++) {
            System.out.println("Please enter the name of person " + (i + 1) + ": ");
            name[i] = sc.nextLine();    // read the name from the user

            // validate the phone number entered by the user
            while (true) {
                System.out.println("Please enter the phone number of person " + (i + 1) + " (###-###-####): ");
                phoneNumber[i] = sc.nextLine();
                // check if the phone number matches the format ###-###-####
                if (phoneNumber[i].matches("\\d{3}-\\d{3}-\\d{4}")) {
                    break;  // exit the loop if the phone number is valid
                } else {
                    System.out.println("Invalid phone number. Please enter a valid phone number.");
                }
            }
        }
        System.out.println();

        // call the sort method to sort the names and phone numbers in alphabetical order
        sort(name, phoneNumber);
        // call the display method to display the names and phone numbers of the people
        display(name, phoneNumber);
        System.out.println();

        // prompt the user to enter a name to search in the array
        System.out.println("Please enter a name to search in the array:");
        String searchName = sc.nextLine();
        System.out.println();

        // prompt the user to choose between iterative and recursive binary search methods
        System.out.println("Please choose the binary search method to use by typing '1' or '2':\n1. Iterative\n2. Recursive");
        int choice = sc.nextInt();
        sc.nextLine();

        while (repeat) {
            if (choice == 1) {  
                // get the start time of the search
                startTime = Calendar.getInstance().getTimeInMillis();
                // call the iterative binary search method
                found = iterativeBinarySearch(name, searchName, 0, name.length - 1);
                // get the end time of the search
                endTime = Calendar.getInstance().getTimeInMillis();
                // display if the name is found in the array
                System.out.println(found ? "Name found." : "Name not found.");
                // calculate and display the running time of the search
                runningTime = endTime - startTime;
                System.out.println("Iterative search time: " + runningTime + " ms");
            } else if (choice == 2) {
                // get the start time of the search
                startTime = Calendar.getInstance().getTimeInMillis();
                // call the recursive binary search method
                found = recursiveBinarySearch(name, searchName, 0, name.length - 1);
                // get the end time of the search
                endTime = Calendar.getInstance().getTimeInMillis();
                // display if the name is found in the array
                System.out.println(found ? "Name found." : "Name not found.");
                // calculate and display the running time of the search
                runningTime = endTime - startTime;
                System.out.println("Recursive search time: " + runningTime + " ms");
            } else {
                // error message if the user enters an invalid choice
                System.out.println("Invalid choice. Please enter 1 for iterative or 2 for recursive.");
                choice = sc.nextInt();
                sc.nextLine();
                continue;
            }
            System.out.println();

            // prompt the user if they want to search for another name
            System.out.print("Do you want to search for another name? ('Y'/'N'): ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                // exit the program
                System.out.println("Thank you for using the program! :D");
                repeat = false;
            } else if (!answer.equalsIgnoreCase("Y")) {
                // error message if the user enters an invalid choice
                System.out.println("Invalid choice. Please enter 'Y' to search again or 'N' to exit.");
            }
        }
    }

    /**
     * Displays the names and phone numbers of the people
     * 
     * @param name
     * @param phoneNumber
     * @return void
     */
    public static void display(String[] name, String[] phoneNumber) {
        System.out.println("Names and phone numbers of the people:");
        for (int i = 0; i < name.length; i++) {
            System.out.println((i + 1) + ". " + name[i] + ", " + phoneNumber[i]);
        }
    }

    /**
     * Sorts the array of names and their corresponding phone numbers based on
     * alphabetical order
     * 
     * @param name
     * @param phoneNumber
     * @return void
     */
    public static void sort(String[] name, String[] phoneNumber) {
        for (int i = 0; i < name.length - 1; i++) {
            for (int j = i + 1; j < name.length; j++) {
                if (name[i].compareTo(name[j]) > 0) {
                    // swap names
                    String temp = name[i];
                    name[i] = name[j];
                    name[j] = temp;
    
                    // swap corresponding phone numbers
                    String temp2 = phoneNumber[i];
                    phoneNumber[i] = phoneNumber[j];
                    phoneNumber[j] = temp2;
                }
            }
        }
    }

    /**
     * Performs iterative binary search to search the array for a specific name
     * 
     * @param name
     * @param searchName
     * @param low
     * @param high
     * @return boolean
     */
    public static boolean iterativeBinarySearch(String[] name, String searchName, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (name[mid].compareTo(searchName) == 0) {
                return true;
            } else if (name[mid].compareTo(searchName) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    /**
     * Performs recursive binary search to search the array for a specific name
     * 
     * @param name
     * @param searchName
     * @param low
     * @param high
     * @return boolean
     */
    public static boolean recursiveBinarySearch(String[] name, String searchName, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (name[mid].compareTo(searchName) == 0) {
                return true;
            } else if (name[mid].compareTo(searchName) < 0) {
                return recursiveBinarySearch(name, searchName, mid + 1, high);
            } else {
                return recursiveBinarySearch(name, searchName, low, mid - 1);
            }
        }
        return false;
    }

} // end SearchingExercise1 class
