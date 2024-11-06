/* Author: Hayley So
 * Date: 11/04/2024
 * JDK version: 22.0.2
 * Description: This program
 */

import java.util.Scanner; // import Scanner class
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar; // import Calendar class

public class SearchingExercises {

    static Scanner sc = new Scanner(System.in); // create Scanner object
    static final int SIZE = 5; // create constant variable to store the size of the two arrays

    /**
     * Main method that executes the program
     * 
     * @param args
     * @return void
          * @throws FileNotFoundException 
          */
        public static void main(String[] args) throws FileNotFoundException {
        String[] name = new String[SIZE];
        String[] phoneNumber = new String[SIZE];
        System.out.println("Welcome to the program!");

        System.out.println("Please enter the names and phone numbers of 5 people");
        for (int i = 0; i < name.length; i++) {
            System.out.println("Please enter the name of person " + (i + 1) + ": ");
            name[i] = sc.nextLine();

            while (true) {
                System.out.println("Please enter the phone number of person " + (i + 1) + " (###-###-####): ");
                phoneNumber[i] = sc.nextLine();

                if (phoneNumber[i].matches("\\d{3}-\\d{3}-\\d{4}")) {
                    break;
                } else {
                    System.out.println("Invalid phone number. Please enter a valid phone number.");
                }
            }

        }
        sort(name, phoneNumber);
        display(name, phoneNumber);

        System.out.println("Please enter a name to search in the array:");
        String searchName = sc.nextLine();

        System.out.println("Please choose the binary search method to use:\n1. Iterative\n2. Recursive");
        int choice = sc.nextInt();
        sc.nextLine(); 

        long startTime, endTime, runningTime;

        while (true) {
            if (choice == 1) {
                startTime = Calendar.getInstance().getTimeInMillis();
                iterativeBinarySearch(name, searchName, 0, name.length - 1);
                endTime = Calendar.getInstance().getTimeInMillis();
                runningTime = endTime - startTime;
                System.out.println("Iterative search time: " + runningTime + " ms");
            } else if (choice == 2) {
                recursiveBinarySearch(name, searchName, 0, name.length - 1);
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 for iterative or 2 for recursive.");
                choice = sc.nextInt();
                sc.nextLine(); 
            }
        }

        String filePath = "C:\\Users\\hayle\\ICS4U1\\Binary Search\\wordlist.txt";
        String[] wordList = loadWordFile(filePath);
        
        System.out.println("Word list loaded. Enter a word to search in the file:");
        String searchWord = sc.nextLine();
        System.out.println("Choose the binary search method to use:\n1. Iterative\n2. Recursive");
        int fileChoice = sc.nextInt();
        sc.nextLine(); 
        
        if (fileChoice == 1) {
            iterativeBinarySearch(wordList, searchWord, 0, wordList.length - 1);
        } if (fileChoice == 2) {
            recursiveBinarySearch(wordList, searchWord, 0, wordList.length - 1);
        } else {
            System.out.println("Invalid choice. Please enter 1 for iterative or 2 for recursive.");
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
     */
    public static void sort(String[] name, String[] phoneNumber) {
        for (int i = 0; i < name.length - 1; i++) {
            int j = i + 1;
            if (name[i].compareTo(name[j]) > 0) {
                String temp = name[i];
                name[i] = name[j];
                name[j] = temp;

                String temp2 = phoneNumber[i];
                phoneNumber[i] = phoneNumber[j];
                phoneNumber[j] = temp2;
            }
        }
    }

    /**
     * Performs iterative binary search to search the array for a specific name
     * 
     * @param name
     * @param searchName
     * @return void
     */
    public static boolean iterativeBinarySearch(String[] name, String searchName, int low, int high) {
        while (low <= high) {
            
        }
    }
    
    /**
     * Performs recursive binary search to search the array for a specific name
     * 
     * @param name
     * @param searchName
     * @param low
     * @param high
     */
    public static boolean recursiveBinarySearch(String[] name, String searchName, int low, int high) {
       
    }

    /**
     * 
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public static String[] loadWordFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        int lineCount = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            lineCount++;
        }
        sc.close();
        sc = new Scanner(file);

        String[] wordList = new String[lineCount];
        for (int i = 0; i < lineCount; i++) {
            wordList[i] = sc.nextLine().trim();
        }
        sc.close();
        return wordList;

    }
}
