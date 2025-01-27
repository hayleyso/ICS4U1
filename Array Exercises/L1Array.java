import java.util.*;
import java.text.DecimalFormat; 

public class L1Array {
    static Scanner sc = new Scanner(System.in);   
    static final int MAX = 10;                     

    public static void main(String[] args) {
        int list[] = new int[MAX]; 
        int aSorted[] = new int[MAX]; 
        int sum; 

        initializeArray(list);
        enterFromKeyboard(list);

        while (true) {
            System.out.println();
            System.out.println("--------HAYLEY'S ARRAY EXERCISES MAIN MENU--------");
            System.out.println("     Would you like to:\n" +
                               "          1. Count the # of whole numbers in the array\n" +
                               "          2. Display the numbers in the array in the order entered\n" +
                               "          3. Display the numbers in the array in reverse\n" +
                               "          4. Find the sum of the numbers in the array\n" +
                               "          5. Find the average of the numbers in the array\n" +
                               "          6. Find the maximum number in the array\n" +
                               "          7. Find the minimum number in the array\n" +
                               "          8. Search the array for a number\n" +
                               "          9. Sort the array using bubble sort\n" +
                               "          10. Sort the array using an improved bubble sort method\n" +
                               "          11. Exit the program");
            System.out.print("Enter # of desired action: ");        
            String option = sc.nextLine(); 
            switch (option) {  
                case "1":
                    countWhole(list); 
                    break;
                case "2":
                    display(list, false); 
                    break;
                case "3":
                    displayReverse(list); 
                    break;
                case "4":
                    sum = sum(list);  
                    System.out.println("The sum of the numbers in the array is " + sum + "."); 
                    break;
                case "5":
                    sum = sum(list); 
                    average(list, sum); 
                    break;
                case "6":
                    findMax(list);    
                    break;
                case "7":
                    findMin(list);    
                    break;
                case "8":
                    search(list); 
                    break;
                case "9":
                    aSorted = sort(list); 
                    display(aSorted, true);   
                    break;
                case "10":
                    aSorted = improvedBubbleSort(list);   
                    display(aSorted, true);  
                    break;
                case "11":
                    System.out.println("Thank you for using the program! :)");  
                    return;
                default:
                    System.out.println("Please enter a valid # from the menu.");  
            } 
        } 
    } 

    public static void initializeArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = -1;  
        } 
    }

    public static void enterFromKeyboard(int[] list) {
        for (int i = 0; i < list.length; i++) { 
            boolean validInput = false; 
            while (!validInput) {   
                System.out.print("Please enter an integer " + (i + 1) + "/" + list.length + ": ");
                try {   
                    list[i] = Integer.parseInt(sc.nextLine());
                    validInput = true; 
                } catch (NumberFormatException e) {
                    System.out.println("Try again. Please enter an integer value.");
                } 
            } 
        }
    }

    public static void countWhole(int[] list) {
        int counter = 0;   
        for (int i = 0; i < list.length; i++) {    
            if (list[i] > 0) { 
                counter++; 
            }
        } 
        System.out.println("The number of positive integers is " + counter + ".");
    }


    public static void display(int[] list, boolean sorted) {
        if (sorted) {
            System.out.print("The integers in ascending order are: ");
        } else {
            System.out.print("The integers in order entered are: ");
        }

        for (int i = 0; i < list.length; i++) { 
            if (i < MAX - 1) {
                System.out.print(list[i] + ", ");
            } else {   
                System.out.print(list[i] + ".");
            }
        }
        System.out.println();   
    }

    public static void displayReverse(int[] list) {
        System.out.print("The integers in reverse order are: ");

        for (int i = MAX - 1; i >= 0; i--) {   
            if (i > 0) {  
                System.out.print(list[i] + ", ");
            } else {  
                System.out.print(list[i] + ".");
            }
        } 
        System.out.println();
    } 

    public static int sum(int[] list) {
        int sum = 0;  
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum;
    } 

    public static void average(int[] list, int sum) {
        DecimalFormat format = new DecimalFormat("0.0"); 
        double average = (double) sum / list.length;    

        if (average % 1 == 0) { 
            System.out.println("The average of the numbers in the array is " + average + ".");
        } else {
            System.out.println("The average of the numbers in the array rounded to 1 decimal place is " + format.format(average) + ".");
        }
    }

    public static void findMax(int[] list) {
        int max = list[0];  
        for (int i = 0; i < list.length; i++) { 
            if (list[i] > max) {   
                max = list[i];  
            }
        } 
        System.out.println("The maximum number in the array is " + max + ".");
    } 

    public static void findMin(int[] list) {
        int min = list[0]; 
        for (int i = 0; i < list.length; i++) { 
            if (list[i] < min) {    
                min = list[i]; 
            }
        } 
        System.out.println("The minimum number in the array is " + min + ".");
    } 

    public static void search(int[] list) {
        boolean validInput = false;

        while (!validInput) {      
            System.out.print("Please enter a number to search for in the array: ");
            String input = sc.nextLine(); 

            try { 
                int numSearch = Integer.parseInt(input); 
                validInput = true;                    

                boolean found = false;  

                for (int i = 0; i < list.length; i++) { 
                    if (list[i] == numSearch) { 
                        if (!found) {
                            System.out.print("The number " + numSearch + " is found in the following position(s): ");
                            found = true;
                        } else {
                            System.out.print(", ");
                        }
                        System.out.print(i);
                    }
                }
                if (!found) {   
                    System.out.println("The number " + numSearch + " was not found in the array.");
                }
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage() + ". Please enter an integer value.");
            } 
        } 
    } 

    public static int[] sort(int[] list) {
        int[] sortedList = new int[MAX]; 

        System.arraycopy(list, 0, sortedList, 0, list.length); 

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (sortedList[j] > sortedList[j + 1]) {
                    int temp = sortedList[j];
                    sortedList[j] = sortedList[j + 1];
                    sortedList[j + 1] = temp;
                }
            }
        }
        return sortedList; 
    }

    public static int[] improvedBubbleSort(int[] list) {
        int[] sortedList = new int[MAX];
        System.arraycopy(list, 0, sortedList, 0, MAX);
        boolean swapped = true; 
        int temp;   
        int i = 0;  
 
        while (swapped) { 
            swapped = false;   
            for (int j = 0; j < list.length - 1 - i; j++) { 
                if (sortedList[j] > sortedList[j + 1]) {   
                    temp = sortedList[j];
                    sortedList[j] = sortedList[j + 1];
                    sortedList[j + 1] = temp;
                    swapped = true; 
                }
            } 
            i++;    
        } 
        return sortedList;
    } 
 
} 