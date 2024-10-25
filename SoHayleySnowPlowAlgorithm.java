/* [SoHayleySnowPlowAlgorithm.java]
 * Author: Hayley So
 * Date: October 31, 2024
 * JDK version: 22.02
 * Description: This program simulates a snow plow clearing operation using recursion. It generates a grid where 1s
 *              represent snow to be cleared and 2s represent obstacles. The plow starts from the first element in the
 *              first row and recursively clears connected areas of snow until it reaches an obstacle. 
 */

import java.util.Scanner; // Import Scanner class for user input

public class SoHayleySnowPlowAlgorithm {

    /**
     * main
     * Main method that executes the snow plow algorithm
     * 
     * @param String[] args - command line arguments
     * @return void
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // Create a scanner object to accept user input
        Scanner sc = new Scanner(System.in);
        // Initialize flag to repeat program
        Boolean isRepeat = true;

        while (isRepeat) {
            // Prompt user for grid dimensions
            System.out.println("\u001B[0m" + "Please enter the number of rows:");
            int row = sc.nextInt();
            System.out.println("\u001B[0m" + "Please enter the number of columns:");
            int col = sc.nextInt();

            // Initialize grid
            // Fill grid with random 1s and 2s
            int[][] arr = new int[row][col];
            fill(arr); // Call fill method

            // Display the grid
            System.out.println("Original grid:");
            display(arr);   // Call display method

            // Initialize flag to check if plow was used
            boolean isPlowUsed = false;

            // Scan for first '1' in the first row
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[0][i] == 1) { // TO-DO: Fix bug
                    clear(arr, 0, i);   // Call clear method with coordinates of the first 1
                    isPlowUsed = true;
                    break;
                }
            }
            // Report if plow was used (if there was a 1 in the first row)
            if (isPlowUsed) {
                System.out.println("The plow was used for the first row.");
            } else {
                System.out.println("The plow was not used for the first row."); 
            }
            // Display grid after clearing
            System.out.println("Grid after clearing:");
            display(arr);

            // Check if user wants to repeat program
            while (true) {
                // Prompt user to repeat or exit
                System.out.println("Would you like to clear snow on another grid? <'Y'/'N'>");
                String repeat = sc.next();  // Accept user input
                if (repeat.equalsIgnoreCase("N")) {
                    System.out.println("Program terminated. Thank you for using the snow plow algorithm!");
                    isRepeat = false;
                    break;
                } else if (repeat.equalsIgnoreCase("Y")) {
                    break;
                } else {
                    // Error message for invalid input
                    System.out.println("Invalid input. Please enter 'Y' to clear snow on another grid or 'N' to exit.");
                }
            }
        }
    } // End main method

    /**
     * fillArray
     * Method to fill a 2D array with random 1s and 2s
     * 
     * @param int[][] arr - the 2D array to be filled
     * @return void
     */
    public static void fill(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) Math.round(Math.random() * 1) + 1;
            }
        }
    } // End fillArray method

    /**
     * display
     * Method to display a 2D array with colours for each number
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
            System.out.println("\u001B[0m"); // Reset colour to default
        }
        System.out.println();
    } // End display method

    /**
     * clear
     * Method to clear snow recursively from a 2D array
     * 
     * @param int[][] arr - the 2D array to be cleared
     *                int x - the x-coordinate of the current cell
     *                int y - the y-coordinate of the current cell
     */
    public static void clear(int[][] arr, int x, int y) throws InterruptedException {
        // Base case
        // If out of bounds or not a 1, return without clearing
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] != 1) {
            return;
        }
        arr[x][y] = 0; // Clear current cell

        display(arr); // Display grid as snow is being cleared
        Thread.sleep(500); // Pause for 1 second before clearing next cell

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