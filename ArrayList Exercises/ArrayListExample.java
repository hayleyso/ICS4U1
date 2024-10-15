import java.util.*;
public class ArrayListExample {
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(3);
        list.add(1, 5);
        list.add(8);

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
