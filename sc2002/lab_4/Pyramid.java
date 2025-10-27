public class Pyramid extends Shape{
    private double base,height;
    public Pyramid(double base, double height){
        this.height=height;
        this.base=base;
    }
    public double calcArea(){
        return 2*base*height+base*base;
    }
}
