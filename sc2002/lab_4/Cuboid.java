public class Cuboid extends Shape{
    private double length,breadth,width;
    public Cuboid(double length, double breadth,double width){
        this.length=length;
        this.breadth=breadth;
        this.width=width;
    }
    public double calcArea(){
        return 2*(length*breadth+breadth*width+width*length);
    }
}
