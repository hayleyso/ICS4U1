package OOP.Fish;

public class Goldfish extends Fish {

    private String eyesType;

    public Goldfish(String name, String color, float weight, String eyesType) {
        this.eyesType = eyesType;
        super(name, color, weight);
    }

    public String getEyesType() {
        return eyesType;
    }

    public void setEyesType(String eyesType) {
        this.eyesType = eyesType;
    }

    public void getInfo() {
        System.out.println("Name: " + name + "\nColor: " + color + "\nWeight: " + weight + "\nEyes type: " + eyesType);
    }

    public void ateTooMuch() {
        super.setWeight(super.getWeight() * 2);
    }
    
}
