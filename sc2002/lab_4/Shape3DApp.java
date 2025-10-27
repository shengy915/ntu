import java.util.ArrayList;
import java.util.Scanner;

public class Shape3DApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sel = 0;
        ArrayList<Shape> shapes = new ArrayList<>();
        do {
            System.out.print("Enter shape number to calc area\n" +
                    "(1) Sphere\n" +
                    "(2) Cubuid\n" +
                    "(3) Pyramid\n" +
                    "(4) Cone\n" +
                    "(5) Cylinder\n" +
                    "(6) Print Area\n" +
                    "(7) Quit\nChoose an option: ");
            sel = sc.nextInt();
            
            switch(sel)
            {
                case 1:
                    System.out.print("Enter radius: ");
                    shapes.add(new Sphere(sc.nextDouble()));
                    break;
                case 2:
                    System.out.print("Enter length: ");
                    double l = sc.nextDouble();
                    System.out.print("Enter breadth: ");
                    double b = sc.nextDouble();
                    System.out.print("Enter width: ");
                    double w = sc.nextDouble();
                    shapes.add(new Cuboid(l, b, w));
                    break;
                case 3:
                    System.out.print("Enter base: ");
                    double base2 = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double h2 = sc.nextDouble();
                    shapes.add(new Pyramid(base2,h2));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double h = sc.nextDouble();
                    System.out.print("Enter slope: ");
                    double slope = sc.nextDouble();
                    shapes.add(new Cone(base, h, slope));
                    break;
                case 5:
                    System.out.print("Enter base: ");
                    double r = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double height = sc.nextDouble();
                    shapes.add(new Cylinder(r, height));
                    break;

                case 6:
                    double totalArea = 0;
                    for (Shape s : shapes) {
                        totalArea += s.calcArea();
                    }
                    System.out.printf("\nTotal surface area of all shapes: %.2f\n", totalArea);
                    break;
            }

        } while (sel != 7);
    sc.close();
    }
}
