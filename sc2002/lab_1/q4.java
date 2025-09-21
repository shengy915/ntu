import java.util.Scanner;

public class q4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("height:");
        int h = sc.nextInt();
        String s = new String();
        for (int i = 0; i < h; i++){
            if(i%2 == 0){
                s = "AA" + s;
            }else{
                s = "BB" + s;
            }
            System.out.println(s);
        }
    }
}
