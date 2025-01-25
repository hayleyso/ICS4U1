import java.util.Scanner;

public class BunnyEars2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter ears:");
        int bunnies = sc.nextInt();
        int ears =  bunnyEars(bunnies);
        System.out.println(ears);
    }

    public static int bunnyEars(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return 3 + bunnyEars(n-1);
        }
        else {
            return 2 + bunnyEars(n-1);
        }
    }
}
