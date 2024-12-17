public class TestShapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape myShapes = new Shape[3];
        char response;
        
        while (shapeCount < 3) {  
            System.out.println("What kind of shape would you like to draw? (c = circle, s = square, t = triangle)");
            response = sc.nextLine().charAt(0); 

            if (response == 'c') {
                myShapes[shapeCount] = new Circle();
                shapeCount++; 
            } else if (response == 's') {
                myShapes[shapeCount] = new Square();
                shapeCount++;  
            } else if (response == 't') {
                myShapes[shapeCount] = new Triangle();
                shapeCount++;  
            } else {
                System.out.println("Invalid input, please enter 'c', 's', or 't' for a valid shape.");
            }
        }
        System.out.println("Here are the shapes you entered:");
        for (int i = 0; i < myShapes.length; i++) {
            myShapes[i].draw();
        }
    }
}