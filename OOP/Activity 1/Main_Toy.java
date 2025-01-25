import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_Toy {

  public static void main(String[] args) {
    ArrayList<Toy> list = new ArrayList<Toy>();

    Toy car = new Toy("Bobby", 100, 120);
    Toy barbie = new Toy("Barbie", 80, 110);
    Toy doll = new Toy("Doll", 70, 100);

    barbie.setCost(90);
    barbie.setSellingPrice(120);

    list.add(car);
    list.add(barbie);
    list.add(doll);

    System.out.println("Names of the objects:");
    for (Toy toy : list) {
      System.out.println(toy.getName());
    }

    System.out.println("Cost of each object:");
    for (Toy toy : list) {
      System.out.println(toy.getName() + ": " + toy.getCost());
    }

    Collections.sort(list, Comparator.comparingDouble(Toy::getProfit));
    System.out.println("Names and profit from lowest to highest:");
    for (Toy toy : list) {
      System.out.println(toy.getName() + ": " + toy.getProfit());
    }

    // Class and objects:
    // - Similarities:
    //    - Both are fundamental OOP concepts
    //    - Represent real-world entities
    // - Differences:
    //    - Class is a blueprint/template, abstract, no memory allocation
    //    - Object is an nstance, concrete, allocates memory

    // Instance and class variables:
    // - Similarities:
    //    - Both store data
    //    - Both can be accessed via methods
    // - Differences:
    //    - Instance variables are unique to each object, created with object, accessed via object reference
    //    - Class variables are shared by all objects, declared static, created at program start

    // public versus protected:
    // - Similarities:
    //    - Both control access to class members
    // - Differences:
    //    - Public: Accessible from anywhere
    //    - Protected: Accessible within class and by subclasses, not outside package
  }
}