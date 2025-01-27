package Assessments;
import java.util.Scanner;
public class NumberTriangle {  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 9:");   
        int num = Integer.parseInt(sc.nextLine()); 
        triangle(num);   
        sc.close();
    } 

    public static void triangle(int number) {
        for (int i=1; i<=number; i++) {   
            for (int j=1; j<=i; j++) {  
                System.out.print(j);
            }
            System.out.println();  
        }
    } 
} 