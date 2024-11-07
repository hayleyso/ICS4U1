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
import java.util.Arrays; // import Arrays class
import java.util.Calendar; // import Calendar class

public class SearchingExercise2 {

    // create Scanner object to read user input
    static Scanner sc = new Scanner(System.in);
    // create constant variable to store the file path
    private static final String FILE_PATH = "C:\\Users\\hayle\\ICS4U1\\Binary Search\\wordlist.txt";

    /**
     * Main method that executes the program
     * 
     * @param args - command line arguments
     * @throws FileNotFoundException
     * @return void
     */
    public static void main(String[] args) throws FileNotFoundException {
        // create a variable to store the file path of the text file
        // call the loadWordFile method to load the words from the file
        String[] wordList = loadWordFile(FILE_PATH);
        // initialize a boolean variable to store if the user wants to repeat the search
        boolean repeat = true;
        // declare variables to store the start, end time, and running time of the search
        long startTime, endTime, runningTime;
        // initialize boolean variable to store if the word is found in the file
        boolean found = false;

        // sort the array of words in alphabetical order
        Arrays.sort(wordList);
        // call the display method
        display(wordList);

        while (repeat) {    // outer loop to repeat the search
            // prompt the user to enter a word to search in the file
            System.out.println("Please enter a word to search in the file:");
            String searchWord = sc.nextLine();
            System.out.println();

            while (true) { // first inner loop to choose between iterative and recursive binary search
                // prompt the user to choose between the recursive or iterative binary search methods
                System.out.println(
                        "Please choose the binary search method to use by typing '1' or '2':\n1. Iterative\n2. Recursive");
                String choice = sc.nextLine(); // read and store the user's choice
                System.out.println();

                if (choice.equals("1")) {
                    // get the start time of the search
                    startTime = Calendar.getInstance().getTimeInMillis();
                    // call the iterative binary search method
                    found = binarySearch(wordList, searchWord, 0, wordList.length - 1);
                    // get the end time of the search
                    endTime = Calendar.getInstance().getTimeInMillis();
                    // calculate and display the running time of the search
                    runningTime = endTime - startTime;
                    System.out.println("Iterative search time: " + runningTime + " ms");
                } else if (choice.equals("2")) {
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
                System.out.println(found ? "The word '" + searchWord + "' was found in the file."
                        : "The word '" + searchWord + "' was not found in the file.");
                System.out.println();
                break;  // exit the first inner loop
            } // end first inner loop

            while (true) { // inner loop to prompt the user to search for another word
                // prompt the user to search for another word
                System.out.println("Do you want to search for another word? ('Y'/'N')");
                String answer = sc.nextLine(); // read and store the user's choice
                System.out.println();

                if (answer.equalsIgnoreCase("N")) {
                    // exit the program
                    System.out.println("Thank you for using the program! :D");
                    repeat = false; // set repeat to false to exit the outer loop
                    break; // exit the second inner loop
                } else if (answer.equalsIgnoreCase("Y")) {
                    break; // repeat the search
                } else {
                    // error message if the user enters an invalid choice
                    System.out.println("Invalid choice. Please enter 'Y' to search again or 'N' to exit.");
                }
            } // end second inner loop
        } // end outer loop
    }

    /**
     * Loads the text file and stores the words in an array
     * 
     * @param filePath - the file path of the text file
     * @throws FileNotFoundException 
     * @return String[] - the array of words
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
     * @param wordList - the array of words
     * @return void 
     */
    public static void display(String[] wordList) {
        System.out.println("The words in the file in numbered format are:");
        for (int i = 0; i < wordList.length; i++) {
            System.out.println((i + 1) + ". " + wordList[i]);
        }
        System.out.println();
    }

    /**
     * Performs iterative binary search to search the array for a specific item
     * 
     * @param wordList - the array of words
     * @param searchWord - the word to search for
     * @param low - the low index of the array
     * @param high - the high index of the array
     * @return boolean - true if the word is found, false otherwise
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
     * @param wordList - the array of words
     * @param searchWord - the word to search for
     * @param low - the low index of the array
     * @param high - the high index of the array
     * @return boolean - true if the word is found, false otherwise
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

    /* Record your observations in terms of running time. Did you notice any difference?
     * Th recursive search approach is consistently faster than the iterative search approach. For example, for the word "video",
     * the iterative search took 20 ms, while the recursive search took 0 ms. This could be due to system caching or measurement differences.
     * 
     * What are some of your conclusions based on the run time?
     * Iterative search is generally more consistent and scales better, especially for larger datasets.
     * 
     */

} // end SearchingExercise2 class
