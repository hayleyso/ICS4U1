/* Author: Hayley So
 * Description: Lesson 1 Array Exercises for ICS4U1 course
 * Purpose: TO practice using modular programming concepts and manipulate arrays through common operations
 * Date: Sept. 9, 2024
 * JDK version: 22.02
 * */

 import java.util.*;              
 import java.text.DecimalFormat; 
 
 public class L1Array {
    // Create a Scanner object to read input
     static Scanner sc = new Scanner(System.in);   
     // Declar an array to hold 10 integers 
     static final int MAX = 10;                     
    
     // Main method
     public static void main(String[] args) {
         L1Array A = new L1Array(); 
         int list[] = new int[MAX]; 
         int aSorted[] = new int[MAX];  
 
         A.initializeArray(list);
         A.enterFromKeyboard(list);
 
         while (true) {      
             System.out.println();
             System.out.println("--------HAYLEY'S ARRAY EXERCISES MAIN MENU--------");
             System.out.println("     Would you like to:");
             System.out.println("          1. Count the # of whole numbers in the array");
             System.out.println("          2. Display the numbers in the array in the order entered");
             System.out.println("          3. Display the numbers in the array in reverse");
             System.out.println("          4. Find the sum of the numbers in the array");
             System.out.println("          5. Find the average of the numbers in the array");
             System.out.println("          6. Find the maximum number in the array");
             System.out.println("          7. Find the minimum number in the array");
             System.out.println("          8. Search the array for a number");
             System.out.println("          9. Sort the array using bubble sort");
             System.out.println("          10. Sort the array using an improved bubble sort method");
             System.out.println("          11. Exit the program");
             System.out.print("Enter # of desired action: ");
             String option = sc.nextLine(); 
             switch (option) {  
                 case "1":
                     A.countWhole(list); 
                     break;
                 case "2":
                     A.display(list, false); 
                     break;
                 case "3":
                     A.displayReverse(list); 
                     break;
                 case "4":
                     sum = A.sum(list);  
                     System.out.println("The sum of the numbers in the array is " + sum + "."); 
                     break;
                 case "5":
                     sum = A.sum(list); 
                     A.average(list, sum); 
                     break;
                 case "6":
                     A.findMax(list);    
                     break;
                 case "7":
                     A.findMin(list);    
                     break;
                 case "8":
                     A.search(list); 
                     break;
                 case "9":
                     aSorted = A.sort(aSorted); 
                     A.display(aSorted, true);   
                     break;
                 case "10":
                     aSorted = A.improvedBubbleSort(list);   
                     A.display(aSorted, true);  
                     break;
                 case "11":
                     System.out.println("Thank you for using the program! :)");  
                     return;
                 default:
                     System.out.println("Please enter a valid # from the menu.");  
             } 
         } 
     } 
 
     /* Initializes all the array elements to -1.
      * @param int[] list - array holding integer values
      * @return void
      * */
     public void initializeArray(int[] list) {
         for (int i = 0; i < MAX; i++) { // Loop through all indices in the array
             list[i] = -1;   // Assign -1 to the current index
         } // End for loop
     } // End initializeArray method
 
     /* Accepts 10 integers from the user.
      * @return void
      * @param int[] list - array holding integer values
      * */
     public void enterFromKeyboard(int[] list) {
         for (int i = 0; i < MAX; i++) { // Loop through all indices in the array
             boolean validInput = false; // Flag to track valid input
             while (!validInput) {   // While loop
                 System.out.print("Please enter an integer " + (i + 1) + "/" + MAX + ": ");
                 try {   // Try-catch for error handling
                     list[i] = Integer.parseInt(sc.nextLine());
                     validInput = true; // Input is valid, set the flag to true
                 } catch (NumberFormatException e) {
                     System.out.println("Try again. Please enter an integer value.");
                 } // End try-catch
             } // End while loop
         } // End for loop
     } // End enterFromKeyboard method
 
     /* Counts the number of positive integers in the array.
      * @param int[] list - array holding integer values
      * @return void
      * */
     public void countWhole(int[] list) {
         int counter = 0;    // Initialize counter to count the number of whole #s
         for (int i = 0; i < MAX; i++) {     // Loop through all indices in the array
             if (list[i] > 0) {  // Check if the number is positive
                 counter++;  // Increment counter
             }
         } // End for loop
         System.out.println("The number of positive integers is " + counter + ".");
     } // end countWhole
 
     /* Displays the numbers in the array in order entered and in ascending order depending on the user's choice.
      * @param int[] list - array holding integer values
      *        boolean sorted - indicate whether to display the sorted or unsorted list
      * */
     public void display(int[] list, boolean sorted) {
         if (sorted) {
             System.out.print("The integers in ascending order are: ");
         } else {
             System.out.print("The integers in order entered are: ");
         }
 
         for (int i = 0; i < MAX; i++) { // Loop through all indices in the array
             if (i < MAX - 1) {  // Add a comma after each number, excluding the last
                 System.out.print(list[i] + ", ");
             } else {    // Add a period after the last number
                 System.out.print(list[i] + ".");
             }
         } // End for loop
         System.out.println();   // Line
     } // End display method
 
     /* Displays the numbers in the array in reverse order entered.
      * @param int[] list - array holding integer values
      * @return void
      * */
     public void displayReverse(int[] list) {
         System.out.print("The integers in reverse order are: ");
 
         for (int i = MAX - 1; i >= 0; i--) {    //Loop through array in reverse order
             if (i > 0) {    // Add a comma after each number, excluding the last
                 System.out.print(list[i] + ", ");
             } else {    // Add a period after the last number
                 System.out.print(list[i] + ".");
             }
         } // End for loop
         System.out.println();
     } // End displayReverse method
 
     /* Calculates the sum of the numbers in the array.
      * @param int[] list - array holding integer values
      * @return sum - sum of the array values
      * */
     public int sum(int[] list) {
         int sum = 0;    // Initialize sum variable
         for (int i = 0; i < MAX; i++) { // Loop through all indices in the array
             sum += list[i]; // Add the current value in the list to the sum
         }
         return sum;
     } // End sum method
 
     /* Calculates the average of the numbers in the array rounded to 1 decimal place.
      * @param int[] list - array holding integer values
      *        int sum - sum of array values
      * @return void
      * */
     public void average(int[] list, int sum) {
         DecimalFormat format = new DecimalFormat("0.0"); // Create a DecimalFormat instance for formatting numbers to 1 decimal place
         double average = (double) sum / MAX;    // Apply casting to get average as a double
 
         if (average % 1 == 0) { // Check if decimals exist
             System.out.println("The average of the numbers in the array is " + average + ".");
         } else {
             System.out.println("The average of the numbers in the array rounded to 1 decimal place is " + format.format(average) + ".");
         }
     } // End average method
 
     /* Finds the maximum number in the array.
      * @param int[] list - array holding integer values
      * @return void
      * */
     public void findMax(int[] list) {
         int max = list[0];  // Initialize max to the first element
         for (int i = 0; i < MAX; i++) { // Loop through all indices in the array
             if (list[i] > max) {    // Check if the current element is greater than max
                 max = list[i];  // Set max to the current element if so
             }
         } // End for loop
         System.out.println("The maximum number in the array is " + max + ".");
     } // End findMax method
 
     /* Finds the minimum number in the array.
      * @param int[] list - array holding integer values
      * @return void
      * */
     public void findMin(int[] list) {
         int min = list[0];  // Initialize min to the first element
         for (int i = 0; i < MAX; i++) { // Loop through all indices in the array
             if (list[i] < min) {    // Check if current element is less than min
                 min = list[i];  // Set min to the current element if so
             }
         } // End for loop
         System.out.println("The minimum number in the array is " + min + ".");
     } // End findMin method
 
     /* Searches for a number in the array and displays their respective positions.
      * @param int[] list - array holding integer values
      * @return void
      * */
     public void search(int[] list) {
         boolean validInput = false; // Flag to track valid input
 
         while (!validInput) {       // Loop until valid input is obtained
             System.out.print("Please enter a number to search for in the array: ");
             String input = sc.nextLine(); // Get user input
 
             try { // Try-catch for error handling
                 int numSearch = Integer.parseInt(input); // Try parsing the input to an integer
                 validInput = true;                       // Set the flag to true if parsing is successful
 
                 boolean found = false;  // Initialize found to false
 
                 for (int i = 0; i < MAX; i++) { // Loop through all indices in the array
                     if (list[i] == numSearch) { // Check if current element equals the searched number
                         if (!found) {
                             System.out.print("The number " + numSearch + " is found in the following position(s): ");
                             found = true;
                         } else {
                             System.out.print(", ");
                         }
                         System.out.print(i);
                     }
                 }
                 if (!found) {   // Print if search number not found in the array
                     System.out.println("The number " + numSearch + " was not found in the array.");
                 }
             } catch (NumberFormatException e) { // Catch invalid input
                 System.out.println("An error occurred: " + e.getMessage() + ". Please enter an integer value.");
             } // End try-catch
         } // End while loop
     } // End search method
 
     /* Bubble sort the array in ascending order without changing the original array.
      * @return int[] - the sorted array
      * @param int[] list - the original array
      */
     public int[] sort(int[] list) {
         int[] sortedList = new int[MAX]; // Create a new array to store sorted values
 
         System.arraycopy(list, 0, sortedList, 0, MAX); // Copy elements from the original array to the new array
 
         // Implementing a simple bubble sort
         for (int i = 0; i < MAX - 1; i++) {
             for (int j = 0; j < MAX - 1 - i; j++) {
                 if (sortedList[j] > sortedList[j + 1]) {
                     // Swap values
                     int temp = sortedList[j];
                     sortedList[j] = sortedList[j + 1];
                     sortedList[j + 1] = temp;
                 }
             }
         }
         return sortedList; // Return the sorted array
     } // End sort method
 
     /* Sorts the array in ascending order using an optimized bubble sort algorithm.
      * @param int[] list - the original array
      * @return int[] - the sorted array
      */
     public int[] improvedBubbleSort(int[] list) {
         int[] sortedList = new int[MAX]; // Create a new array to store sorted values
         System.arraycopy(list, 0, sortedList, 0, MAX); // Copy elements from the original array to the new array
         boolean swapped = true; // Boolean to check if any swaps occurs
         int temp;   // Variable to hold the integer to be swapped
         int i = 0;  // Initialize
 
         while (swapped) { // Continue until no swaps are needed
             swapped = false;    // Assume no swaps will occur in this pass
             for (int j = 0; j < MAX - 1 - i; j++) { // Iterate through the unsorted portion the array
                 if (sortedList[j] > sortedList[j + 1]) {    // Compare adjacent elements
                     // Swap values
                     temp = sortedList[j];
                     sortedList[j] = sortedList[j + 1];
                     sortedList[j + 1] = temp;
                     swapped = true; // Set swapped to true since a swap has occurred
                 }
             } // End for loop
             i++;    // Increase pass count to reduce the range of the next iteration
         } // End while loop
         return sortedList;
     } // End improvedBubbleSort method
 
 } // End ArrayExercises class