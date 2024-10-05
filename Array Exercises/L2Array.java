/* Author: Hayley So
 * Description: Lesson 3 Array Exercises for ICS4U1 course
 * Purpose: This program prompts the user to enter 6 unique integers and outputs 10 unique integers between 1-100 (inclusive)
 * Date: Sept. 15, 2024
 * JDK version: 22.02
 * */
import java.util.Scanner; 

public class L3Array {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        L3Array L = new L3Array();  
        L.noDuplicates();  
        L.randomNoDuplicates(); 
    } 

    /* Prompts the user to enter 6 unique integers and checks it the number entered is not a duplicate.
     * If the number has been entered previously, they will be asked to enter a new number.
     * @param int[] list - array to store 6 integers
     * @return void
     * */
    public void noDuplicates() {
        int[] numList = new int[6]; 
        int counter = 0;
        int input; 

        // Loop to allow the user to enter 6 unique integers
        while (counter < numList.length) { 
            while (true) { 
                if (counter == 0) {   
                    System.out.print("Please enter an integer: ");
                } else {  
                    System.out.print("Please enter a unique integer: ");
                }
                try {   
                    input = Integer.parseInt(sc.nextLine());  
                    break;  // Leave inner while loop
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input " + e.getMessage().toLowerCase() + ".");
                }
            } 

            // Check if the number entered is a duplicate
            if (isDuplicate(numList, counter, input)) {   
                System.out.println("Sorry, that number has already been entered.");
            } else {   
                numList[counter] = input;   
                counter++;  
            }
        } 

        System.out.print("The six unique integers entered were: ");
        for (int i = 0; i < numList.length; i++) {
            if (i == numList.length - 1) { 
                System.out.print(numList[i] + ".");
            } else {    
                System.out.print(numList[i] + ", ");
            }
        }
        System.out.println();
    } // End noDuplicates method

    /* Helper method that checks if the current number entered is a duplicate.
     * @param int[] numList - array to store 6 integers
     *        int length - the number of unique integers entered
     *        int number - the current number being entered
     * @return false - no duplicates
     * */
    private boolean isDuplicate(int[] numList, int length, int number) {
        // Loop through the array to check if the number entered is a duplicate
        for (int i = 0; i < length; i++) { 
            if (numList[i] == number) {
                return true;   
            }
        }
        return false;   
    } // End isDuplicate method

    /* Outputs 10 unique integers between 1-100 (inclusive).
     * @return void
     * */
    public void randomNoDuplicates() {
        int[] numList = new int[10];    
        int count = 0;  

        while (count < numList.length) {   
            // Generate a random number between 1 and 100
            int randNum = (int) (Math.random() * 100) + 1; 

            // Check if the random number is a duplicate
            if (!isDuplicate(numList, count, randNum)) {  
                numList[count] = randNum;  
                count++;   
            }
        } 

        System.out.println("Ten generated random integers between 1-100:");
        // Loop to display each random number
        for (int i = 0; i < numList.length; i++) { 
            if (i < numList.length - 1) {  
                System.out.print(numList[i] + ", ");
            } else { 
                System.out.print(numList[i] + ".");
            }
        } 
    } // End randomNoDuplicates method
} /* End L3Array class */