import java.util.Scanner;

public class Fives {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");

        int num = sc.nextInt();

        sumOfFives(num);

        System.out.println("The number of fives: " + num);
        sc.close();
    }

    public static int sumOfFives(int n) {
        if (n == 0) {
            return 0;
        }
        int lastDigit = n % 10;

        if (lastDigit == 5) {
            return 1 + sumOfFives(n / 10);
        }

        return sumOfFives(n / 10); 
    }
    
}
