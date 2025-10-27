import java.util.Scanner;

public class q2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("pls enter ur income");
        int salary = sc.nextInt();
        
        System.out.println("pls enter ur mp");
        int mp = sc.nextInt();

        if ((salary >=700 && mp >=20) || salary >= 800){
            System.out.println("A");
        }else if (salary >= 650 || (salary >=600 && mp >= 10)) {
            System.out.println("B");
        }else{
            System.out.println("C");
        }
    }
}