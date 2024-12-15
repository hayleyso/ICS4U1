// TestBarbie.java
public class TestBarbie {

    public static void main(String[] args) {
        // Create a Barbie object
        Barbie barbieDoll = new Barbie("Barbie", 80, 120, "Blonde", 30);

        // Display initial info
        System.out.println("Initial Barbie Information:");
        barbieDoll.displayInfo();

        // Change Barbie's hair color
        barbieDoll.changeHairColor("Pink");

        // Display updated info
        System.out.println("\nUpdated Barbie Information:");
        barbieDoll.displayInfo();
    }
}
