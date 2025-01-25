import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Arrays; 
import java.util.Calendar; 

public class SearchingExercise2 {

    static Scanner sc = new Scanner(System.in);
    private static final String FILE_PATH = "C:\\Users\\hayle\\ICS4U1\\Binary Search\\wordlist.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String[] wordList = loadWordFile(FILE_PATH);
        boolean repeat = true;
        long startTime, endTime, runningTime;
        boolean found = false;

        Arrays.sort(wordList);
        display(wordList);

        while (repeat) {   
            System.out.println("Please enter a word to search in the file:");
            String searchWord = sc.nextLine();
            System.out.println();

            while (true) {
                System.out.println(
                        "Please choose the binary search method to use by typing '1' or '2':\n1. Iterative\n2. Recursive");
                String choice = sc.nextLine();
                System.out.println();

                if (choice.equals("1")) {
                    startTime = Calendar.getInstance().getTimeInMillis();
                    found = binarySearch(wordList, searchWord, 0, wordList.length - 1);
                    endTime = Calendar.getInstance().getTimeInMillis();
                    runningTime = endTime - startTime;
                    System.out.println("Iterative search time: " + runningTime + " ms");
                } else if (choice.equals("2")) {
                    startTime = Calendar.getInstance().getTimeInMillis();
                    found = recursiveBinarySearch(wordList, searchWord, 0, wordList.length - 1);
                    endTime = Calendar.getInstance().getTimeInMillis();
                    runningTime = endTime - startTime;
                    System.out.println("Recursive search time: " + runningTime + " ms");
                } else {
                    System.out.println("Invalid choice. Please enter 1 for iterative or 2 for recursive.");
                }
                System.out.println(found ? "The word '" + searchWord + "' was found in the file."
                        : "The word '" + searchWord + "' was not found in the file.");
                System.out.println();
                break;  
            }

            while (true) { 
                System.out.println("Do you want to search for another word? ('Y'/'N')");
                String answer = sc.nextLine(); 
                System.out.println();

                if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Thank you for using the program! :D");
                    repeat = false; 
                    break;
                } else if (answer.equalsIgnoreCase("Y")) {
                    break; 
                } else {
                    System.out.println("Invalid choice. Please enter 'Y' to search again or 'N' to exit.");
                }
            } 
        } 
    }

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

    public static void display(String[] wordList) {
        System.out.println("The words in the file in numbered format are:");
        for (int i = 0; i < wordList.length; i++) {
            System.out.println((i + 1) + ". " + wordList[i]);
        }
        System.out.println();
    }

    public static boolean binarySearch(String[] wordList, String searchWord, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (wordList[mid].compareTo(searchWord) == 0) { 
                return true; 
            } else if (wordList[mid].compareTo(searchWord) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false; 
    }

    public static boolean recursiveBinarySearch(String[] wordList, String searchWord, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2; 
            if (wordList[mid].compareTo(searchWord) == 0) { 
                return true; 
            } else if (wordList[mid].compareTo(searchWord) < 0) { 
                return recursiveBinarySearch(wordList, searchWord, mid + 1, high);
            } else {
                return recursiveBinarySearch(wordList, searchWord, low, mid - 1); 
            }
        }
        return false; 
    }

    /* Record your observations in terms of running time. Did you notice any difference?
     * Th recursive search approach is consistently faster than the iterative search approach. For example, for the word "video",
     * the iterative search took 20 ms, while the recursive search took 0 ms. This could be due to system caching or measurement differences.
     * 
     * What are some of your conclusions based on the run time?
     * Iterative search is generally more consistent and scales better, especially for larger datasets.
     * 
     */

} 
