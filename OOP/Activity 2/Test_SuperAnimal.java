/**
 * Tests the behavior of the SuperAnimal subclass by creating instances and invoking methods.
 */
public class TestSuperAnimal {
    public static void main(String[] args) {
        // Create two SuperAnimal objects with different abilities
        SuperAnimal superAnimal1 = new SuperAnimal("Eagle", "Bird", 5, true, true, false, true);
        SuperAnimal superAnimal2 = new SuperAnimal("Shark", "Fish", 8, false, false, true, true);

        // Test methods for superAnimal1
        System.out.println(superAnimal1.fly());       
        System.out.println(superAnimal1.teleport("mountain"));  
        System.out.println(superAnimal1.swim());          

        // Test methods for superAnimal2
        System.out.println(superAnimal2.fly());           
        System.out.println(superAnimal2.teleport("ocean"));  
        System.out.println(superAnimal2.swim());        

        // Test inherited method from Animal class
        superAnimal1.eat();   
    }
}
