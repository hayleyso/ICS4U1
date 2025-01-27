import java.util.Scanner; 

public class SearchingExercise1 {

    static Scanner sc = new Scanner(System.in); 
    static final int SIZE = 5; 

    public static void main(String[] args) {
        String[] name = new String[SIZE];
        String[] phoneNumber = new String[SIZE];

        boolean found;
        boolean repeat = true;
        boolean repeatSearch = true;

        while (repeat) {    
            System.out.println("Please enter the names and phone numbers of 5 people.");
            System.out.println();
            for (int i = 0; i < name.length; i++) {
                System.out.println("Please enter the name of person " + (i + 1) + ": ");
                name[i] = sc.nextLine(); 

                while (true) {  
                    System.out.println("Please enter the phone number of person " + (i + 1) + " (###-###-####): ");
                    phoneNumber[i] = sc.nextLine();

                    if (phoneNumber[i].matches("\\d{3}-\\d{3}-\\d{4}")) {
                        break; 
                    } else {
                        System.out.println("Invalid phone number. Please enter a valid phone number.");
                    }
                } 
            }
            System.out.println();

            sort(name, phoneNumber);
            display(name, phoneNumber);
            System.out.println();

            while (repeatSearch) {  
                System.out.println("Please enter a name to search in the array:");
                String searchName = sc.nextLine();
                System.out.println();

                found = binarySearch(name, searchName, 0, name.length - 1);
                System.out.println( 
                        found ? "The name '" + searchName + "' was found." : "The name '" + searchName + "'' was not found.");
                System.out.println();

                System.out.print("Do you want to search for another name? ('Y'/'N'): ");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Thank you for using the program! :D");
                    repeatSearch = false;  
                    repeat = false;
                } else if (!answer.equalsIgnoreCase("Y")) {
                    System.out.println("Invalid choice. Please enter 'Y' to search again or 'N' to exit.");
                }
            } 
        } 
    }

    public static void display(String[] name, String[] phoneNumber) {
        System.out.println("Names and phone numbers of the people:");
        for (int i = 0; i < name.length; i++) {
            System.out.println((i + 1) + ". " + name[i] + ", " + phoneNumber[i]);
        }
    }

    public static void sort(String[] name, String[] phoneNumber) {
        for (int i = 0; i < name.length - 1; i++) {
            for (int j = i + 1; j < name.length; j++) {
                if (name[i].compareTo(name[j]) > 0) {
                    String temp = name[i];
                    name[i] = name[j];
                    name[j] = temp;

                    String temp2 = phoneNumber[i];
                    phoneNumber[i] = phoneNumber[j];
                    phoneNumber[j] = temp2;
                }
            }
        }
    }

    public static boolean binarySearch(String[] name, String searchName, int low, int high) {
        while (low <= high) { 
            int mid = low + (high - low) / 2; 

            if (name[mid].compareTo(searchName) == 0) {
                return true;
            } else if (name[mid].compareTo(searchName) < 0) {
                return binarySearch(name, searchName, mid + 1, high);
            } else {
                return binarySearch(name, searchName, low, mid - 1);
            }
        }
        return false; 
    }

}