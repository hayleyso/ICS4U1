/* Author: Hayley So
 * Date: 11/07/2024
 * JDK version: 22.0.2
 * Description: This program loads and stors the words from the text file, 'wordlist' into an array.
 *              It then prompts the user to enter a word to search for an item and choose between
 *              iterative and recursive binary search methods to find the word.
 */

import java.util.Scanner; // import Scanner class
import java.io.File; // import File class
import java.io.FileNotFoundException; // import FileNotFoundException class
import java.util.Arrays;
import java.util.Calendar; // import Calendar class

public class SearchingExercise2 {

    static Scanner sc = new Scanner(System.in); // create Scanner object
    static final int SIZE = 5; // create constant variable to store the size of the two arrays
    private static final String FILE_PATH = "C:\\Users\\hayle\\ICS4U1\\Binary Search\\wordlist.txt";

    /**
     * Main method that executes the program
     * 
     * @param args
     * @throws FileNotFoundException
     * @return void
     */
    public static void main(String[] args) throws FileNotFoundException {
        // create a variable to store the file path of the text file
        // call the loadWordFile method to load the words from the file
        String[] wordList = loadWordFile(FILE_PATH);
        // boolean variable to store if the user wants to repeat the search
        boolean repeat = true;

        // intialize variables to store the start, end time, and running time of the search
        long startTime, endTime, runningTime;
        // boolean variable to store if the word is found in the file
        boolean found = false;

        // sort the array of words in alphabetical order
        Arrays.sort(wordList);
        // call the display method 
        display(wordList);
        System.out.println();

        while (repeat) {
            // prompt the user to enter a word to search in the file
            System.out.println("Please enter a word to search in the file:");
            String searchWord = sc.nextLine();
            System.out.println();

            // prompt the user to choose between iterative and recursive binary search methods
            System.out.println("Please choose the binary search method to use by typing '1' or '2':\n1. Iterative\n2. Recursive");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if (choice == 1) {
                // get the start time of the search
                startTime = Calendar.getInstance().getTimeInMillis();
                // call the iterative binary search method
                found = binarySearch(wordList, searchWord, 0, wordList.length - 1);
                // get the end time of the search
                endTime = Calendar.getInstance().getTimeInMillis();
                // calculate and display the running time of the search
                runningTime = endTime - startTime;
                System.out.println("Iterative search time: " + runningTime + " ms");
            } else if (choice == 2) {
                // get the start time of the search
                startTime = Calendar.getInstance().getTimeInMillis();
                // call the recursive binary search method
                found = recursiveBinarySearch(wordList, searchWord, 0, wordList.length - 1);
                // get the end time of the search
                endTime = Calendar.getInstance().getTimeInMillis();
                // calculate and display the running time of the search
                runningTime = endTime - startTime;
                System.out.println("Recursive search time: " + runningTime + " ms");
            } else {
                // error message if the user enters an invalid choice
                System.out.println("Invalid choice. Please enter 1 for iterative or 2 for recursive.");
            }
            // display if the word is found in the file
            System.out.println(found ? "Word found in the file." : "Word not found in the file.");
            System.out.println();

            // prompt the user to search for another word
            System.out.println("Do you want to search for another word? ('Y'/'N')");
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
     * Loads the text file and stores the words in an array
     * 
     * @param filePath
     * @return String[]
     * @throws FileNotFoundException
     */
    public static String[] loadWordFile(String filePath) throws FileNotFoundException {
        // create a File object and Scanner object to read the file
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        // initialize a variable to store the number of lines in the file
        int lineCount = 0;

        // count the number of lines in the file
        while (sc.hasNextLine()) {
            sc.nextLine();
            lineCount++;
        }
        sc.close(); // close the Scanner object
        sc = new Scanner(file); // create a new Scanner object to read the file

        // create an array to store the words in the file
        String[] wordList = new String[lineCount];
        // iterate through the file and store the words in the array
        for (int i = 0; i < lineCount; i++) {
            wordList[i] = sc.nextLine().trim();
        }
        sc.close(); // close the Scanner object
        return wordList; // return the array of words
    }

    /**
     * Displays the words in numbered format
     * 
     * @param wordList
     * @return void
     */
    public static void display(String[] wordList) {
        System.out.println("The words in the file in numbered format are:");
        for (int i = 0; i < wordList.length; i++) {
            System.out.println((i + 1) + ". " + wordList[i]);
        }
    }

    /**
     * Performs iterative binary search to search the array for a specific item
     * 
     * @param wordList
     * @param searchWord
     * @param low
     * @param high
     * @return boolean
     */
    public static boolean binarySearch(String[] wordList, String searchWord, int low, int high) {
        
        // iterate through the array and search for the word
        while (low <= high) {
            int mid = low + (high - low) / 2; // calculate the middle index of the array
            if (wordList[mid].compareTo(searchWord) == 0) { // check if the word is found
                return true; // value found
            } else if (wordList[mid].compareTo(searchWord) < 0) { // check if the word is in the right half of the array
                low = mid + 1; // update the low index
            } else { // check if the word is in the left half of the array
                high = mid - 1; // update the high index
            }
        }
        return false; // value not found
    }

    /**
     * Performs recursive binary search to search the array for a specific item
     * 
     * @param wordList
     * @param searchWord
     * @param low
     * @param high
     * @return boolean
     */
    public static boolean recursiveBinarySearch(String[] wordList, String searchWord, int low, int high) {
        // iterate through the array and search for the word
        if (low <= high) {
            int mid = low + (high - low) / 2; // calculate the middle index of the array
            if (wordList[mid].compareTo(searchWord) == 0) { // check if the word is found
                return true; // value found
            } else if (wordList[mid].compareTo(searchWord) < 0) { // check if the word is in the right half of the array
                return recursiveBinarySearch(wordList, searchWord, mid + 1, high); // search the right half of the array
            } else { // check if the word is in the left half of the array
                return recursiveBinarySearch(wordList, searchWord, low, mid - 1); // search the left half of the array
            }
        }
        return false; // value not found
    }

} // end SearchingExercise2 class
