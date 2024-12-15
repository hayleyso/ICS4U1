/**
 * Represents an animal with attributes such as class, species, name, age,
 * and domestication status, along with behaviors like eating, sleeping, etc.
 */
public class Animal {
    // declare instance variables
    private String animalClass;
    private String species;
    private String name;
    private int age;
    private boolean isDomesticated;

    // Constructor
    public Animal(String animalClass, String species, String name, int age, boolean isDomesticated) {
        this.animalClass = animalClass;
        this.species = species;
        this.name = name;
        this.age = age;
        this.isDomesticated = isDomesticated;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass() {
        this.animalClass = animalClass;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies() {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }

    public boolean getIsDomesticated() {
        return isDomesticated;
    }

    public void setIsDomesticated() {
        this.isDomesticated = isDomesticated;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void move() {
        System.out.println(name + " is moving");
    }

    public void makeNoise() {
        System.out.println(name + " is making noise");
    }

    public void play() {
        System.out.println(name + " is playing");
    }

    }