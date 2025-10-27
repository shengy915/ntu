import java.util.Scanner;

public class CircleApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Circle circle = null;
		int option;
		
		do {
			System.out.println("====  Circle Computation  ====");
			System.out.println("| 1. Create a new circle     |");
			System.out.println("| 2. Print Area              |");
			System.out.println("| 3. Print Circumference     |");
			System.out.println("| 4. Quit                    |");
			System.out.println("==============================");
		
			System.out.println("\nChoose option (1 - 3): ");
			option = sc.nextInt();
		
		
			switch(option) {
			case 1:
				System.out.println("Enter the radius to compute the area and circumference");
				double r = sc.nextDouble();
				circle = new Circle(r);
				System.out.println("A new circle is created\n");
				break;
				
			case 2:
				if (circle != null) {
					circle.printArea();
				} else {
					System.out.println("Please create a circle");
				}
				break;
			
			case 3:
				if (circle != null) {
					circle.printCircumference();
				} else {
					System.out.println("Please create a circle");
				}
				break;
				
			case 4:
				System.out.println("\nThank you!!");
				break;
			}
		} while (option != 4);
		sc.close();
	}
}
