/**
 * Tests the behavior of the Animal class by creating instances and invoking methods.
 */
public class Test_Animal (

    public static void main(String[] args) {
        Animal animal1 = new Animal("Mammal", "Canus lupus familiaris", "Ellie", 6, true);
        Animal animal2 = new Animal("Mammal", "Ornithorhynchus anatinus", "Perry", 100, true);

        animal1.setAge("7");
        animal1.eat();
        
    }
)