public class Test_Animal {

    public static void main(String[] args) {
        Animal animal1 = new Animal("Mammal", "Canus lupus familiaris", "Ellie", 6, true);
        Animal animal2 = new Animal("Mammal", "Ornithorhynchus anatinus", "Perry", 100, true);

        animal1.setAge(); 
        animal1.eat();
    }
}
