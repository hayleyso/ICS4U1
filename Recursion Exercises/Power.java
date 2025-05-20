import java.util.*;
public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a real number (base):");
        double base = sc.nextDouble();

        System.out.println("Enter an integer (exponent):");
        int exp = sc.nextInt();

        double dPower = Pow(base, exp);

        System.out.printf("The value of " + base + " to the power of " + exp + " is %.2f", dPower);

        sc.close();
    }

    public static double Pow(double b, int e) {
        if (e == 0 || b==1) {
            return 1;
        }
        if (e > 0) {
            return b * Pow(b, e - 1);
        }
        else {
            return 1 / Pow(b, e);
        }
    }
}
