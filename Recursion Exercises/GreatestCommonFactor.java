import java.util.*;

public class GreatestCommonFactor {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter integer 1:");
        int num1 = sc.nextInt();
        System.out.println("Please enter integer 2:");
        int num2 = sc.nextInt();

        System.out.printf("The GCF of %d and %d is %d", num1, num2, GCF(num1, num2));
    }

    public static int GCF(int a, int b) {
        if (a==b) {
            return a;
        } else if(a>b) {
            return GCF(b, a-b);
        } else {   
            return GCF(b, a);
        }
    }
}
