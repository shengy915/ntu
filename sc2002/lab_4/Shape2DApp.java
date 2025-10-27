import java.util.Scanner;
import java.util.ArrayList;
public class Shape2DApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sel = 0;
        ArrayList<Shape> shapes = new ArrayList<>();
        do {
            System.out.print("Enter shape number to calc area\n" +
                    "(1) Circle\n" +
                    "(2) Rectangle\n" +
                    "(3) Square\n" +
                    "(4) Triangle\n" +
                    "(5) Print Area\n" +
                    "(6) Quit\nChoose an option: ");
            sel = sc.nextInt();
            
            switch(sel)
            {
                case 1:
                    System.out.print("Enter radius: ");
                    shapes.add(new Circle2(sc.nextDouble()));
                    break;
                case 2:
                    System.out.print("Enter length: ");
                    double l = sc.nextDouble();
                    System.out.print("Enter breadth: ");
                    double b = sc.nextDouble();
                    shapes.add(new Rectangle(l, b));
                    break;
                case 3:
                    System.out.print("Enter side: ");
                    shapes.add(new Square(sc.nextDouble()));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double h = sc.nextDouble();
                    shapes.add(new Triangle(base, h));
                    break;
                case 5:
                    double totalArea = 0;
                    for (Shape s : shapes) {
                        totalArea += s.calcArea();
                    }
                    System.out.printf("\nTotal surface area of all shapes: %.2f\n", totalArea);
                    break;
            }

        } while (sel != 6);
    sc.close();
    }
}
