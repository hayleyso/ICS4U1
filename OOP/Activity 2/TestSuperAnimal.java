public class TestSuperAnimal {
    public static void main(String[] args) {

        SuperAnimal superAnimal1 = new SuperAnimal("Eagle", "Bird", 5, true, true, false, true);
        SuperAnimal superAnimal2 = new SuperAnimal("Shark", "Fish", 8, false, false, true, true);

        System.out.println(superAnimal1.fly());       
        System.out.println(superAnimal1.teleport("mountain"));  
        System.out.println(superAnimal1.swim());          

        System.out.println(superAnimal2.fly());           
        System.out.println(superAnimal2.teleport("ocean"));  
        System.out.println(superAnimal2.swim());        

        superAnimal1.eat();   
    }
}
