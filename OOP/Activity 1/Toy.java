public class Toy {

    static String nameOfCo = "Toys R Us";

    private String name;
    private double cost;
    private double sellingPrice;

    public Toy(String defaultName, double startCost, double startSellingPrice) {
        name = defaultName;
        cost = startCost;
        sellingPrice = startSellingPrice;
    }

    public Toy() {
        name = "default";
        cost = 0.00;
        sellingPrice = 0.00;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getSellingPrice() { 
        return sellingPrice;
    }

    public void setName(String newName) { 
        name = newName;
    }

    public void setCost(double newCost) { 
        cost = newCost;
    }

    public void setSellingPrice(double newSellingPrice) { 
        sellingPrice = newSellingPrice;
    }

    public double getProfit() { 
        return sellingPrice - cost;
    }
}
