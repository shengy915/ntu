import java.util.Scanner;

public class q1 {
<<<<<<< HEAD
=======

    public static void mulTest(){
        for (int i = 0; i < 5; i++){
            int x = (int) Math.random()*10;
            int y = (int) Math.random()*10;
            int ans = x*y;
            System.out.println("How much is" + x + "times" + y);
        }
    }

>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
            mulTest();
            break;
            case 2: /* add divide() call */
            System.out.print("m:");
            int m = sc.nextInt();

            System.out.print("n:");
            int n = sc.nextInt();
            
            System.out.println(m + "/" + n + "="+ divide(m, n));

            break;
            case 3: /* add modulus() call */
            System.out.print("m:");
            int m1 = sc.nextInt();

            System.out.print("n:");
            int n1 = sc.nextInt();
            
            System.out.println(m1 + "%" + n1 + "="+ modulus(m, n));
            break;
            case 4: /* add countDigits() call */
            System.out.print("n:");
            int n2 = sc.nextInt();
            System.out.println("n:"+n2+" - count"+countDigits(n));
            break;
            
            case 5: /* add position() call */
				System.out.print("Enter n: ");
				int num2 = sc.nextInt();
				
				System.out.print("Enter digit: ");
				int digit = sc.nextInt();
				
				System.out.println("position = " + position(num2, digit));
				break;
				
			case 6: /* add extractOddDigits() call */
				System.out.print("Enter n: ");
				long num3 = sc.nextLong();
				long oddDigits = extractOddDigits(num3);
				
				if (oddDigits != -2)
					System.out.println("oddDigits = " + oddDigits);
				break;
            case 7: System.out.println("Program terminating ….");
            } 
        }while (choice < 7);
        sc.close();
    }

    public static void mulTest(){
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        for (int i = 0; i < 5; i++){
            int x = 1+ (int) (Math.random()*9);
            int y = 1+ (int) (Math.random()*9);

            System.out.println("how much is "+ x + " times "+ y+ "?");
            if (sc.nextInt() == x*y){
                counter++;
            } 
        }
        System.out.println(("u got "+ counter+ " out of 5 correct!"));
    }

    public static int divide(int m, int n) {
        int quotient = 0;
        while (m >= n){
            quotient++;
            m -= n; 
        }
        return quotient;
    }
    public static int modulus(int m, int n) {
        while (m >= n){
            m -= n; 
        }
        return m;
    }
    public static int countDigits(int n) {
        if (n <= 0) {
			System.out.println("n: " + n + " - Error input!!");
			return -1;	
		}
		int count = 0;
		
		while (n > 0) {
			n /= 10;
			count++;
		}
		return count;
    }
    public static int position(int n, int digit) {
		int pos = 1;
		
		while (n > 0) {
			if (n % 10 == digit)
				return pos;
			
			n /= 10;
			pos++;
		}
		return -1;
	}
	
	public static long extractOddDigits(long n) {
		if (n <= 0) {
			System.out.println("oddDigits = Error input!!");
			return -2;
		}
		long result = 0;
		long multiplier = 1;
		
		while (n > 0) {
			int d = (int)(n % 10);
			if (d % 2 != 0) {
				result = d * multiplier + result;
				multiplier *= 10;
			}
			n /= 10;
		}
		if (result == 0)
			return -1;
		
		return result;
	}
=======
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
>>>>>>> refs/remotes/origin/master
}
