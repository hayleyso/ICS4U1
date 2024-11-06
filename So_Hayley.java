/**
 * Author: Hayley So
 * Description: ICS4U - 2D Arrays, ArrayList, Methods, Style, Thinking & Application Test
 * Date: 11/05/2024
 * JDK version: 22.0.2
 */

import java.util.ArrayList; // import ArrayList class
import java.util.Scanner; // import Scanner class to accept user input

public class So_Hayley {
    static Scanner sc = new Scanner(System.in);

    /**
     * Main method that executes the program
     * 
     * @param args command-line arguments (not used)
     * @return void
     */
    public static void main(String[] args) {
        // prompt user to enter the size of the ArrayList
        System.out.print("Please enter the number of values to store in the arraylist: ");
        int num = sc.nextInt(); // read input from user
        System.out.println();

        // declare an ArrayList to be filled with unique integers from 1 to the
        // user-entered value
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        fillArrayList(arrList, num);    // call fillArrayList method

        // display the values in the ArrayList
        System.out.println("The numbers from 1 to " + num + ", stored in a random order in an arraylist is:");
        System.out.println(arrList);
        System.out.println();

        // determine the dimensions for the 2D array
        int size = (int) Math.sqrt(arrList.size()); // apply square root to get the size
        int[][] arr = new int[size][size];  // declare a 2D array with size as its dimensions

        // populate the 2D array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = arrList.get(i * size + j);  // convert values to 2D array values
            }
        }

        // display the 2D array in column-by-column format
        System.out.println("The above values in the array list after storing in a " + num + " x " + num + " 2D array is:");
        for (int j = 0; j < size; j++) { 
            for (int i = 0; i < size; i++) { 
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(); 
        }
        System.out.println();

        // display the sum of each column in the 2D array
        System.out.println("The sum of the values in each column is:");
        sumOfColumns(arr);  // call sumOfColums methood
        System.out.println();

        // display the sums of the diagonals
        System.out.println("The sum of the values in the diagonal from left top to right bottom = "
                + sumOfDiagonalLeftTopToRightBottom(arr));  // call sumOfDiagonalLeftTopToRightBottom method
        System.out.println("The sum of the values in the diagonal from right top to left bottom = "
                + sumOfDiagonalRightTopToLeftBottom(arr));  // call sumOfDiagonalRightTopToLeftBottom method
        System.out.println();
    } 

    /**
     * Fills the ArrayList with unique random numbers between 1 and the user's input
     * number.
     * 
     * @param arrList the ArrayList with unique, random numbers between 1 and num
     * @param num the square number for the ArrayList's size
     * @return void
     */
    public static void fillArrayList(ArrayList<Integer> arrList, int num) {
        while (arrList.size() < num) {
            int value = (int) (Math.random() * num) + 1;    // generate random numbers between 1 and num
            if (!arrList.contains(value)) {     // check for duplicate values
                arrList.add(value);     // add the unique integer to the ArrayList
            }
        }
    }

    /**
     * Calculates and prints the sum of each column in a 2D array.
     * 
     * @param arr the 2D array with unique, random numbers between 1 and num
     * @return void
     */
    public static void sumOfColumns(int[][] arr) {
        for (int j = 0; j < arr[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i][j];
            }
            System.out.println(+(j + 1) + ": " + sum);
        }
    }

    /**
     * Calculates the sum of the main diagonal (from top left to bottom right) in
     * the 2D array.
     * 
     * @param arr the 2D array with unique, random numbers between 1 and num
     * @return the sum of the main diagonal
     */
    public static int sumOfDiagonalLeftTopToRightBottom(int[][] arr) {
        int sum = 0;    // declare variable to store the sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];   // accumulate sum of diagonal values
        }
        return sum;
    }

    /**
     * Calculates the sum of the anti-diagonal (from top right to bottom left) in
     * the 2D array.
     * 
     * @param arr the 2D array with unique, random numbers between 1 and num
     * @return the sum of the anti-diagonal
     */
    public static int sumOfDiagonalRightTopToLeftBottom(int[][] arr) {
        int sum = 0;    // declare variable to store the sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][arr.length - 1 - i];    // accumulate sum of diagonal values
        }
        return sum;
    } 

} // End So_Hayley clas