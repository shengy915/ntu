public class Cone extends Shape{
    private double radius,height,slope;
    public Cone(double radius, double height,double slope){
        this.height=height;
        this.radius=radius;
        this.slope=slope;
    }
    public double calcArea(){
        return Math.PI*radius*(radius+slope);
    }
}
