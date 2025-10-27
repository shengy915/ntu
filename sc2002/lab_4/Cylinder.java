public class Cylinder extends Shape{
    private double radius,height;
    public Cylinder(double radius, double height){
        this.height=height;
        this.radius=radius;
    }
    public double calcArea(){
        return Math.PI*radius*2*(height + radius) ;
    }
}
