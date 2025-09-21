import java.util.Scanner;

public class q1 {

    public static void mulTest(){
        for (int i = 0; i < 5; i++){
            int x = (int) Math.random()*10;
            int y = (int) Math.random()*10;
            int ans = x*y;
            System.out.println("How much is" + x + "times" + y);
        }
    }

    public static void main(String args[]){
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Perform the following methods:");
            System.out.println("1: multiplication test");
            System.out.println("2: quotient using division by subtraction");
            System.out.println("3: remainder using division by subtraction");
            System.out.println("4: count the number of digits");
            System.out.println("5: position of a digit");
            System.out.println("6: extract all odd digits");
            System.out.println("7: quit");
            choice = sc.nextInt();
            switch (choice) {
            case 1: /* add mulTest() call */
            break;
            case 2: /* add divide() call */
            break;
            case 3: /* add modulus() call */
            break;
            case 4: /* add countDigits() call */
            break;
            case 5: /* add position() call */
            break;
            case 6: /* add extractOddDigits() call */
            break;
            case 7: System.out.println("Program terminating ….");
            } 
        }while (choice < 7);
    }
}
