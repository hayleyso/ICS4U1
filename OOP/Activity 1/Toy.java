public class Toy {
  // Class variable
  static String nameOfCo = "Toys R Us";

  // Characteristics/State - (Instance variables)
  private String name;
  private double cost;
  private double sellingPrice;

  // Constructor method - has the same name as the class, has parameters that are passed
  public Toy(String defaultName, double startCost, double startSellingPrice) {
      name = defaultName;
      cost = startCost;
      sellingPrice = startSellingPrice;
  }

  // Another constructor method (or any method) - same method name differs by parameters passed, or the number of parameters passed - this is called Method Overloading
  public Toy() {
      name = "default";
      cost = 0.00;
      sellingPrice = 0.00;
  }

  // Behaviours: Communicators and Actions

  // Return type methods to get values - Accessor Method
  public String getName() { // returns name of the object Toy - Accessor method (getter)
      return name;
  }

  public double getCost() { // returns cost of the object Toy - Accessor method (getter)
      return cost;
  }

  public double getSellingPrice() { // returns sellingPrice of the object Toy - Accessor method (getter)
      return sellingPrice;
  }

  // Void type methods to set values and also actions to perform - Modifier method (setter)
  public void setName(String newName) { // sets a new name for the object Toy - Modifier method (setter)
      name = newName;
  }

  public void setCost(double newCost) { // sets a new cost for the object Toy - Modifier method (setter)
      cost = newCost;
  }

  public void setSellingPrice(double newSellingPrice) { // sets a new sellingPrice for the object Toy - Modifier method (setter)
      sellingPrice = newSellingPrice;
  }

  public double getProfit() { // returns the profit for the object Toy, calculated using profit=selling price-cost
      return sellingPrice - cost;
  }
}
