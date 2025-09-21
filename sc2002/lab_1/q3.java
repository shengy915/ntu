import java.util.Scanner;

public class q3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Start val:");
        int start = sc.nextInt();
        System.out.println("end value:");
        int end = sc.nextInt();
        System.out.println("Increment:");
        int incre = sc.nextInt();
        System.out.println("waht loop? 1:For, 2:While, 3:do-while");
        int loop = sc.nextInt();
        System.out.println("US$                S$");
        System.out.println("______________________");
        if (loop == 1){
            for (int i = start; i <= end; i += incre){
                System.out.println(i + "                 " + (i*1.82));
            }
        }else if (loop == 2){
            while (start <= end){
                System.out.println(start + "                 " + (start*1.82));
                start += incre;
            }
        }else if(loop == 3){
            do{
                System.out.println(start + "                 " + (start*1.82));
                start += incre;
            }while (start <= end);
        }
    }
}
