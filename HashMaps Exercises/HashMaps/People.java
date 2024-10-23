import java.util.HashMap;

public class People {

    public static void main(String[] args) {

        HashMap<String, Integer> people = new HashMap<String, Integer>();

        // Add keys and values (Name, Age)
        people.put("John", 32);
        people.put("Steve", 30);
        people.put("Angie", 33);

        // Loop through the keys of the HashMap
        for (String i : people.keySet()) {
            System.out.println("Name: " + i + " Age: " + people.get(i));
        }
    
        // Example usage of getName method
        String result = getName(people, 32);
        System.out.println("Person with age 32: " + result);
    }

    public static String getName(HashMap<String, Integer> list, int size) {
        for (String name : list.keySet()) {
            if (list.get(name) == size) {
                return name;    // Return the name 
            }
        }
        return null; // Return null if no matching size is found
    }
    
}
