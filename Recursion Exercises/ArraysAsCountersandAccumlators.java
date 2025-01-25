import java.util.Scanner;

public class ArraysAsCountersandAccumlators {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[] list = new int[10];
        int num;

        System.out.println("Please enter a number:");
        num = sc.nextInt();

        while (num > 0 && num < 11) {
            list[num - 1]++;     
            System.out.println("Please enter a number.");
            num = sc.nextInt();
        }

        System.out.printf("%-10s %s%n", "Number", "# of Occurrences");
        
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d %d%n", (i + 1), list[i]);
        }
        sc.close();
    }
}