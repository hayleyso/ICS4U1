 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 
 public class L3Array {
    
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
 
     } 

     public int[][] readFromFile() throws FileNotFoundException {
         File file = new File("C:\\Users\\hayle\\OneDrive\\Documents\\2D_array_input.txt");
         Scanner scanner = new Scanner(file);
 
         int numRows = scanner.nextInt();
         int numColumns = scanner.nextInt();
         int[][] array = new int[numRows][numColumns];
 
         for (int i = 0; i < numRows; i++) {
             for (int j = 0; j < numColumns; j++) {
                 array[i][j] = scanner.nextInt();
             }
         }
         scanner.close();    
         return array;
     } 
 
     public void displayArray(int[][] num) {
         for (int i = 0; i < num.length; i++) {
             for (int j = 0; j < num[i].length; j++) {
                 System.out.print(num[i][j] + "\t");
             }
             System.out.println();
         }
     } 

     public void displayTransposedArray(int[][] num) {
         for (int j = 0; j < num[0].length; j++) {
             for (int i = 0; i < num.length; i++) {
                 System.out.print(num[i][j] + "\t");
             }
             System.out.println();
         }
     }

     public void displayArrayAndSum(int[][] num) {
         int numRows = num.length;
         int numColumns = num[0].length;
 
         int[] rowSum = new int[numRows];
         int[] colSum = new int[numColumns];
 
         for (int i = 0; i < numRows; i++) {
             for (int j = 0; j < numColumns; j++) {
                 rowSum[i] += num[i][j];
                 colSum[j] += num[i][j];
             }
         }
 
         for (int i = 0; i < numRows; i++) {
             for (int j = 0; j < numColumns; j++) {
                 System.out.print(num[i][j] + "\t");
             }
             System.out.println("| Row " + (i + 1) + " sum: " + rowSum[i]);
         }
 
         System.out.println("Column sums:");
         for (int j = 0; j < numColumns; j++) {
             System.out.print(colSum[j] + "  ");
         }

         System.out.println();
     } 
 
 } 