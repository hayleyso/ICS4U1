/* Author: Hayley So
 * Date: October 31, 2024
 * JDK version: 22.0.2
 * Description: This program simulates a snow plow clearing operation using recursion. It generates a grid where 1s
 *              represent snow to be cleared and 2s represent obstacles. The plow starts from the first element in the
 *              first row and recursively clears connected areas of snow until it reaches an obstacle. 
 */

import java.util.InputMismatchException; // Import for handling input errors
import java.util.Scanner; // Import Scanner class for user input

public class SoHayleySnowPlowAlgorithm {

    /**
     * Main method that executes the snow plow algorithm
     * 
     * @param args - command line arguments (not used)
     * @return void
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in); // Create a scanner object to accept user input
        Boolean isRepeat = true; // Initialize flag to repeat program

        while (isRepeat) {
            // Initialize variables to store user-defined dimensions
            int row = 0, col = 0;

            // Loop for error handling
            while (true) {
                // Try-catch block to handle invalid input
                try {  
                    // Prompt user to enter dimensions of the grid
                    System.out.println("Please enter the number of rows:");
                    row = sc.nextInt();
                    System.out.println("Please enter the number of columns:");
                    col = sc.nextInt();

                    // Check if dimensions are positive integers
                    if (row > 0 && col > 0) {
                        break;  // Exit loop if valid input
                    } else {    // Display error message if input is invalid
                        System.out.println("Invalid. Both dimensions must be positive integers.");
                    }
                } catch (InputMismatchException e) {    // Catch invalid input
                    System.out.println("Invalid input. Please enter integers only.");
                    sc.nextLine(); // Clear the invalid input
                } // End try-catch block
            } 
            int[][] arr = new int[row][col]; // Create a 2D array with user-defined dimensions
            fill(arr); // Call fill method

            System.out.println("Original grid:");
            display(arr); // Call display method

            // Initialize flag to check if plow was used
            boolean isPlowUsed = false;
            // Scan for first '1' in the first row
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[0][i] == 1) {   // Check if element is a 1
                    clear(arr, 0, i); // Call clear method with coordinates of the first 1
                    isPlowUsed = true;  // Set flag to true
                    break;              // Exit loop after clearing first 1
                }
            }
            // Display grid after clearing
            System.out.println("Grid after clearing:");
            display(arr); // Call display method

            // Report if plow was used (if there was a 1 in the first row)
            if (isPlowUsed) {
                System.out.println("The plow was used for the first row.");
            } else {
                System.out.println("The plow was not used for the first row.");
            }

            // Check if user wants to repeat program with error-handling
            while (true) {
                // Prompt user to repeat or exit
                System.out.println("Would you like to clear snow on another grid? <'Y'/'N'>");
                String repeat = sc.next(); // Accept user input
                if (repeat.equalsIgnoreCase("N")) {
                    System.out.println("Program terminated. Thank you for using the snow plow algorithm!");
                    isRepeat = false; // Set flag to false to exit program
                    sc.close(); // Close scanner
                    break; // Exit loop
                } else if (repeat.equalsIgnoreCase("Y")) {
                    break; // Exit loop to repeat program
                } else {
                    System.out.println("Invalid input. Please enter 'Y' to clear snow on another grid or 'N' to exit.");
                }
            } // End inner while loop
        }
    } // End main method

    /**
     * Fills the 2D array with random 1s and 2s
     * 
     * @param int[][] arr - the 2D array to be filled
     * @return void
     */
    public static void fill(int[][] arr) {
        // Nested loop to iterate through the rows and columns of the 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) Math.round(Math.random() * 1) + 1; // Randomly assign 1 or 2 to each cell
            }
        }
    } // End fill method

    /**
     * Displays the 2D array with colour coding for the different digits
     * 
     * @param int[][] arr - the 2D array to be displayed
     * @return void
     */
    public static void display(int[][] arr) {
        // Nested loop to iterate through the rows and columns of the 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.print("\u001B[32m" + arr[i][j] + " "); // Green for zeroes
                } else if (arr[i][j] == 1) {
                    System.out.print("\u001B[31m" + arr[i][j] + " "); // Red for ones
                } else {
                    System.out.print("\u001B[34m" + arr[i][j] + " "); // Blue for twos
                }
            }
            System.out.println("\u001B[0m"); // Reset colour to default and move to the next2
        }
        System.out.println();
    } // End display method

    /**
     * Clears snow recursively from a 2D array
     * 
     * @param int[][] arr - the 2D array to be cleared
     * @param int x - the x-coordinate of the current cell
     * @param int y - the y-coordinate of the current cell
     * @return void
     * @throws InterruptedException
     */
    public static void clear(int[][] arr, int x, int y) throws InterruptedException {
        // Base case
        // If out of bounds or not a 1, return without clearing
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] != 1) {
            return;
        }
        arr[x][y] = 0; // Clear current cell

        display(arr); // Display grid as snow is being cleared
        Thread.sleep(500); // Pause for half a second before clearing next cell

        // Recursively clear all eight surrounding positions
        clear(arr, x - 1, y); // Up
        clear(arr, x + 1, y); // Down
        clear(arr, x, y - 1); // Left
        clear(arr, x, y + 1); // Right
        clear(arr, x - 1, y - 1); // Up-Left Diagonal
        clear(arr, x - 1, y + 1); // Up-Right Diagonal
        clear(arr, x + 1, y - 1); // Down-Left Diagonal
        clear(arr, x + 1, y + 1); // Down-Right Diagonal

    } // End clear method

} /* End SoHayleySnowPlowAlgorithm class */