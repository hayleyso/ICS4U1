import java.util.*;
public class ArrayList1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();


    }
    
    public static void enterFromKeyboard(ArrayList<Integer> list) {
       for (int i=0; i<10; i++) {
        System.out.println("Please enter an integer:");
        list.set(sc.nextInt(), i);
    }
    }
}
