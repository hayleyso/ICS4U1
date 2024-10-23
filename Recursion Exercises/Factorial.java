import java.util.*;

public class Factorial {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter a number:");
        int num = sc.nextInt();
        double factValue = Fact(num);
        System.out.printf("The factorial of %d is %d.", num, factValue);
    }

    public static double Fact(int iNum) {
        if (iNum <= 1) {
            return 1;
        } else {
            return iNum * Fact(iNum-1);
        }
    }
}
