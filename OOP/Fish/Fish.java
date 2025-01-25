package OOP.Fish;

public class Fish {
    protected String name;
    protected String color;
    protected float weight;

    public Fish(String name, String color, float weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
