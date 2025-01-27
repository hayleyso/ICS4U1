import java.util.Scanner; 

public class L2Array {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        L2Array L = new L2Array();  
        L.noDuplicates();  
        L.randomNoDuplicates(); 
    } 

    public void noDuplicates() {
        int[] numList = new int[6]; 
        int counter = 0;
        int input; 

        while (counter < numList.length) { 
            while (true) { 
                if (counter == 0) {   
                    System.out.print("Please enter an integer: ");
                } else {  
                    System.out.print("Please enter a unique integer: ");
                }
                try {   
                    input = Integer.parseInt(sc.nextLine());  
                    break; 
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input " + e.getMessage().toLowerCase() + ".");
                }
            } 

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
    }

    private boolean isDuplicate(int[] numList, int length, int number) {
        for (int i = 0; i < length; i++) { 
            if (numList[i] == number) {
                return true;   
            }
        }
        return false;   
    } 

    public void randomNoDuplicates() {
        int[] numList = new int[10];    
        int count = 0;  

        while (count < numList.length) {   
            int randNum = (int) (Math.random() * 100) + 1; 

            if (!isDuplicate(numList, count, randNum)) {  
                numList[count] = randNum;  
                count++;   
            }
        } 

        System.out.println("Ten generated random integers between 1-100:");

        for (int i = 0; i < numList.length; i++) { 
            if (i < numList.length - 1) {  
                System.out.print(numList[i] + ", ");
            } else { 
                System.out.print(numList[i] + ".");
            }
        } 

    } 
} 