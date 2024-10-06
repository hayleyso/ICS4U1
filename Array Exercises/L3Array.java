/* Author: Hayley So
 * Description: Two Dimensional Array Exercise #1 for ICS4U1 class.
 * Purpose: Review of using file handling to receive input from a file and manipulate 2D arrays.
 * Date: 09/18/2024
 * JDK version: 22.02
 */
 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 
 public class L3Array {
    
    // Main method 
     public static void main(String[] args) {
         L3Array A = new L3Array();
         int[][] array;
 
         try {
             array = A.readFromFile();
 
             System.out.println("\nOriginal array:");
             A.displayArray(array);
 
             System.out.println("\nTransposed array:");
             A.displayTransposedArray(array);
 
             System.out.println("\nArray with row and column sums:");
             A.displayArrayAndSum(array);
 
         } catch (FileNotFoundException e) {
             System.out.println("File not found. Please check the file path.");
         }
 
     } // End main method
 
     /* Reads a file to indicate the 2D array size and fills the array with the file's contents
     * @throws FileNotException for handling file errors
     * @return (int[][]) array - filled array
     * */
     public int[][] readFromFile() throws FileNotFoundException {
         File file = new File("C:\\Users\\hayle\\OneDrive\\Documents\\2D_array_input.txt");
         Scanner scanner = new Scanner(file);
 
         // Read file for row and column size and set as the array dimensions
         int numRows = scanner.nextInt();
         int numColumns = scanner.nextInt();
         int[][] array = new int[numRows][numColumns];
 
         // Read file to store the array values
         for (int i = 0; i < numRows; i++) {
             for (int j = 0; j < numColumns; j++) {
                 array[i][j] = scanner.nextInt();
             }
         }
         scanner.close();    // Close scanner to ensure no resource leaks and effective resource management
 
         return array;
     } // End readFromFile method
 
     /* Displays the original array.
     * @param int[][] num - 2D array containing integers
     * @return void
     * */
     public void displayArray(int[][] num) {
         for (int i = 0; i < num.length; i++) {
             for (int j = 0; j < num[i].length; j++) {
                 System.out.print(num[i][j] + "\t");
             }
             System.out.println();
         }
     } // End displayArray
 
     /* Displays the transposed array.
     * @param int[][] num - 2D array containing integers
     * @return void
     * */
     public void displayTransposedArray(int[][] num) {
         for (int j = 0; j < num[0].length; j++) {
             for (int i = 0; i < num.length; i++) {
                 System.out.print(num[i][j] + "\t");
             }
             System.out.println();
         }
     } // End displayTransposedArray
 
     /* Displays the array with the row and column sums.
     * @param int[][] num - 2D array containing integers
     * @return void
     * */
     public void displayArrayAndSum(int[][] num) {
         int numRows = num.length;
         int numColumns = num[0].length;
 
         int[] rowSum = new int[numRows];
         int[] colSum = new int[numColumns];
 
         // Calculate row and column sums
         for (int i = 0; i < numRows; i++) {
             for (int j = 0; j < numColumns; j++) {
                 rowSum[i] += num[i][j];
                 colSum[j] += num[i][j];
             }
         }
 
         // Display row sums
         for (int i = 0; i < numRows; i++) {
             for (int j = 0; j < numColumns; j++) {
                 System.out.print(num[i][j] + "\t");
             }
             System.out.println("| Row " + (i + 1) + " sum: " + rowSum[i]);
         }
 
         // Display column sums
         System.out.println("Column sums:");
         for (int j = 0; j < numColumns; j++) {
             System.out.print(colSum[j] + "  ");
         }
         System.out.println();
     } // End displayArrayAndSum
 
 } /* End Array41 class */