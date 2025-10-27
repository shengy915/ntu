import java.util.Scanner;

public class q1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("wat movies do u like?");
        String letter = sc.next();
        switch (letter) {
            case "A", "a":
                System.out.println("Action Movie Fan");
                break;
            
            case "C", "c":
                System.out.println("Comedy Movie Fan");
                break;
            
            case "D", "d":
                System.out.println("Drama Movie Fan");
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
}
