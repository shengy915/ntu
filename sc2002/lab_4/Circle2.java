

public class Circle2 extends Shape{
	private double radius;
    public Circle2(double radius){
        this.radius=radius;
    }
    public double calcArea(){
        return Math.PI*radius *radius;
    }
}
