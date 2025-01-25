public class TestBarbie {

    public static void main(String[] args) {
        Barbie barbieDoll = new Barbie("Barbie", 80, 120, "Blonde", 30);

        System.out.println("Initial Barbie Information:");
        barbieDoll.displayInfo();
        barbieDoll.changeHairColor("Pink");

        System.out.println("\nUpdated Barbie Information:");
        barbieDoll.displayInfo();
    }
}
