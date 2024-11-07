/* Author: Hayley So
 * Date: 11/07/2024
 * JDK version: 22.0.2
 * Description: This programs prompts the uesr to enter 5 names and their corresponding phone numbers.
 *              It then asks the user to search for a name in the array and choose between iterative
 *              and recursive binary search methods to find the name.
 */

import java.util.Scanner; // import Scanner class

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
        // create a variable to store if the name is found in the array
        boolean found;
        // initialize boolean variables to store if the user wants to repeat the search
        boolean repeat = true;
        boolean repeatSearch = true;

        while (repeat) {    // outer loop to repeat the search
            // prompt the user to enter the names and phone numbers of 5 people
            System.out.println("Please enter the names and phone numbers of 5 people.");
            System.out.println();
            for (int i = 0; i < name.length; i++) {
                System.out.println("Please enter the name of person " + (i + 1) + ": ");
                name[i] = sc.nextLine(); // read the name from the user

                // validate the phone number entered by the user
                while (true) {  // first inner loop to validate the phone number
                    System.out.println("Please enter the phone number of person " + (i + 1) + " (###-###-####): ");
                    phoneNumber[i] = sc.nextLine();
                    // check if the phone number matches the format ###-###-####
                    if (phoneNumber[i].matches("\\d{3}-\\d{3}-\\d{4}")) {
                        break; // exit the loop if the phone number is valid
                    } else {
                        System.out.println("Invalid phone number. Please enter a valid phone number.");
                    }
                } // end first inner loop
            }
            System.out.println();

            // call the sort method to sort the names and phone numbers in alphabetical order
            sort(name, phoneNumber);
            // call the display method to display the names and phone numbers of the people
            display(name, phoneNumber);
            System.out.println();

            while (repeatSearch) {  // second inner loop to repeat the search
                // prompt the user to enter a name to search in the array
                System.out.println("Please enter a name to search in the array:");
                String searchName = sc.nextLine();
                System.out.println();

                // call the binary search method to search for the name
                found = binarySearch(name, searchName, 0, name.length - 1);
                // display the result of the search
                System.out.println( 
                        found ? "The name '" + searchName + "' was found." : "The name '" + searchName + "'' was not found.");
                System.out.println();

                // prompt the user if they want to search for another name
                System.out.print("Do you want to search for another name? ('Y'/'N'): ");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("N")) {
                    // exit the program
                    System.out.println("Thank you for using the program! :D");
                    repeatSearch = false;   // exit the inner loop
                    repeat = false; // exit the outer loop
                } else if (!answer.equalsIgnoreCase("Y")) {
                    // error message if the user enters an invalid choice
                    System.out.println("Invalid choice. Please enter 'Y' to search again or 'N' to exit.");
                }
            } // end second inner loop
        } // end outer loop
    }

    /**
     * Displays the names and phone numbers of the people
     * 
     * @param name - array of names
     * @param phoneNumber - array of phone numbers
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
     * @param name - array of names
     * @param phoneNumber - array of phone numbers
     * @return void
     */
    public static void sort(String[] name, String[] phoneNumber) {
        for (int i = 0; i < name.length - 1; i++) {
            for (int j = i + 1; j < name.length; j++) {
                // compare the names of the people 
                // and swap them if they are not in alphabetical order
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
     * Performs recursive binary search to search the array for a specific name
     * 
     * @param name - array of names
     * @param searchName - name to search for
     * @param low - low index of the array
     * @param high - high index of the array
     * @return boolean
     */
    public static boolean binarySearch(String[] name, String searchName, int low, int high) {
        while (low <= high) { // iterate through the array and search for the name
            int mid = low + (high - low) / 2; // calculate the middle index of the array

            if (name[mid].compareTo(searchName) == 0) { // check if the name is found
                return true; // value found
            } else if (name[mid].compareTo(searchName) < 0) {
                // check if the name is in the right half of the array
                return binarySearch(name, searchName, mid + 1, high);
            } else {
                // check if the name is in the left half of the array
                return binarySearch(name, searchName, low, mid - 1);
            }
        }
        return false; // value not found
    }

} // end SearchingExercise1 class
