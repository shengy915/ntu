public class Sphere extends Shape{
    private double radius;
    public Sphere(double radius){
        this.radius=radius;
    }
    public double calcArea(){
        return 4*Math.PI*radius *radius;
    }
}
