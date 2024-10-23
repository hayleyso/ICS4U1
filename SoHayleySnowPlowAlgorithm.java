/* Author: Hayley So
 * Title:  Recursive Snow Plow Simulation Algorithm
 * Purpose: This program simulates a snow plow clearing operation using recursion. It generates a grid where 1s
 *          represent snow to be cleared and 2s represent obstacles. The plow starts from the first row and recursively
 *          clears connected areas of snow until it reaches an obstacle. 
 * Date Created: 10/23/2024
 * JDK version: 22.02
 */

import java.util.Scanner;

public class SoHayleySnowPlowAlgorithm {

    // Main method that runs when the program is executed
    public static void main(String[] args) throws InterruptedException {
        // Create a scanner object to accept user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for grid dimensions
        System.out.println("\u001B[0m" + "Please enter the number of rows:");
        int row = sc.nextInt();
        System.out.println("\u001B[0m" + "Please enter the number of columns:");
        int col = sc.nextInt();
        sc.close();

        // Initialize grid
        int[][] arr = new int[row][col];
        fillArray(arr);

        System.out.println("Original grid:");
        display(arr);

        // Initialize flag to check if plow was used
        boolean isPlowUsed = false;
        
        // Scan for first '1' in the first row
        for (int i = 0; i < arr[0].length; i++) {
                if (arr[i][0] == 1) {
                    clear(arr, i, 0);
                    isPlowUsed = true;
                    break;
                }
            }
        // Report if plow was used
        if (isPlowUsed) {
            System.out.println("The plow was used for the first row.");
            System.out.println();
        } else {
            System.out.println("The plow was not used for the first row.");
            System.out.println();
        }

        // Display grid after clearing
        System.out.println("Grid after clearing:");
        display(arr);
        
    }

    // Randomly fill array with 1s and 2s
    public static void fillArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) Math.round(Math.random() * 1) + 1;
            }
        }
    }

    // Display array with colour coding
    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.print("\u001B[31m" + arr[i][j] + " "); // Red for zeroes
                } else if (arr[i][j] == 1) {
                    System.out.print("\u001B[32m" + arr[i][j] + " "); // Green for ones
                } else {
                    System.out.print("\u001B[34m" + arr[i][j] + " "); // Blue for twos
                }
            }
            System.out.println("\u001B[0m"); // Reset colour to default
        }
        System.out.println();
    }

    // Clear surrounding 1s recursively until a 2 is reached
    public static void clear(int[][] arr, int x, int y) throws InterruptedException {
        // Base case
        // If out of bounds or not a 1, return without clearing
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] != 1) {
            return;
        }
        arr[x][y] = 0;       // Clear current cell

        display(arr);    // Display grid after clearing
        Thread.sleep(500); // Pause for 1 second before clearing next cell

        // Recursively clear all eight surrounding positions
        clear(arr, x-1, y);   // Up
        clear(arr, x+1, y);   // Down
        clear(arr, x, y-1);   // Left
        clear(arr, x, y+1);   // Right
        clear(arr, x-1, y-1); // Up-Left Diagonal
        clear(arr, x-1, y+1); // Up-Right Diagonal
        clear(arr, x+1, y-1); // Down-Left Diagonal
        clear(arr, x+1, y+1); // Down-Right Diagonal
    }

} /* End SoHayleySnowPlowAlgorithm class */