public class Triangle extends Shape{
    private double base,height;
    public Triangle(double base, double height){
        this.height=height;
        this.base=base;
    }
    public double calcArea(){
        return 0.5*base*height;
    }
}
