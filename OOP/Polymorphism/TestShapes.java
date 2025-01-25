import java.util.Scanner;

public class TestShapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] myShapes = new Shape[3];
        char response;
        
        for (int i = 0; i < myShapes.length; i++) {
            System.out.println("What kind of shape would you like to draw? (c = circle, s = square, t = triangle)");
            response = sc.nextLine().charAt(0); 

            if (response == 'c') {
                myShapes[i] = new Circle();
            } else if (response == 's') {
                myShapes[i] = new Square();
            } else if (response == 't') {
                myShapes[i] = new Triangle();
            } else {
                System.out.println("Invalid input, please enter 'c', 's', or 't' for a valid shape.");
            }
        }
        
        System.out.println("Here are the shapes you entered:");
        for (int i = 0; i < myShapes.length; i++) {
            myShapes[i].draw();
        }

        sc.close();
    }
}