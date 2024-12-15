// Barbie.java
public class Barbie extends Toy {
    // Additional characteristics specific to Barbie
    private String hairColor;
    private double height;

    // Constructor for Barbie class, which uses the parent class constructor
    public Barbie(String name, double cost, double sellingPrice, String hairColor, double height) {
        super(name, cost, sellingPrice); // Call the constructor of the Toy class
        this.hairColor = hairColor;
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getProfit() {
        return super.getProfit(); 
    }

    // Barbie-specific action method
    public void changeHairColor(String newColor) {
        setHairColor(newColor);
        System.out.println("Barbie's hair color has been changed to " + newColor);
    }

    // Display Barbie-specific information
    public void displayInfo() {
        System.out.println("Barbie Name: " + getName());
        System.out.println("Hair Color: " + getHairColor());
        System.out.println("Height: " + getHeight() + " cm");
        System.out.println("Cost: $" + getCost());
        System.out.println("Selling Price: $" + getSellingPrice());
        System.out.println("Profit: $" + getProfit());
    }
}
