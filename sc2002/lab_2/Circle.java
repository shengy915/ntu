public class Circle {
	private double radius;
	private static final double PI = 3.14159;
	
	// constructor
	public Circle(double rad) {
		radius = rad;
	}
	
	// mutator method
	public void setRadius(double rad) {
		radius = rad;
	}
	
	// accessor method
	public double getRadius() {
		return radius;
	}
	
	// calculate area
	public double area() {
		return PI * radius * radius;
	}
	
	// calculate circumference
	public double circumference() {
		return 2 * PI * radius;
	}
	
	// print area
	public void printArea() {
		System.out.println("\nArea of circle");
		System.out.println("Radius: " + radius);
		System.out.println("Area: " + area() + "\n");
	}
	
	// print circumference 
	public void printCircumference() {
		System.out.println("\nCircumference of circle");
		System.out.println("Radius: " + radius);
		System.out.println("Circunference: " + circumference() + "\n");
	}
	
}
