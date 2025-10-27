import java.util.Scanner;

public class q1_ans {
	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\nPerform the following methods.");
			System.out.println("1. multiplication test");
			System.out.println("2. quotient using division by substraction");
			System.out.println("3. remainder using division by substraction");
			System.out.println("4. count the number of digits");
			System.out.println("5. position of a digit");
			System.out.println("6. extract all odd digits");
			System.out.println("7. quit");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				mulTest();
				break;
			
			case 2:
				System.out.print("Enter m: ");
				int m1 = sc.nextInt();
				
				System.out.print("Enter n: ");
				int n1 = sc.nextInt();
				
				System.out.println(m1 + "/" + n1 + " = " + divide(m1, n1));
				break;
				
			case 3:
				System.out.print("Enter m: ");
				int m2 = sc.nextInt();
				
				System.out.print("Enter n: ");
				int n2 = sc.nextInt();
				
				System.out.println(m2 + " % " + n2 + " = " + modulus(m2, n2));
				break;
				
			case 4:
				System.out.print("Enter a positive integer: ");
				int num1 = sc.nextInt();
				int count = countDigits(num1);
				
				if (count != -1) 
					System.out.println("n: " + num1 + " - count = " + count);
				break;
			
			case 5:
				System.out.print("Enter n: ");
				int num2 = sc.nextInt();
				
				System.out.print("Enter digit: ");
				int digit = sc.nextInt();
				
				System.out.println("position = " + position(num2, digit));
				break;
				
			case 6:
				System.out.print("Enter n: ");
				long num3 = sc.nextLong();
				long oddDigits = extractOddDigits(num3);
				
				if (oddDigits != -2)
					System.out.println("oddDigits = " + oddDigits);
				break;
				
			case 7:
				System.out.println("Program terminating...");
			}
			
		} while (choice < 7);
		sc.close();		
	}
	
	public static void mulTest() {
		Scanner sc = new Scanner(System.in);
		int correct = 0;
		
		for (int i = 0; i < 5; i++) {
			int a = 1 + (int)(Math.random() * 9);
			int b = 1 + (int)(Math.random() * 9);
			
			System.out.print("How much is " + a + " times " + b + " ? ");
			int ans = sc.nextInt();
			
			if (ans == a * b) {
				correct++;
			}
		}
		System.out.println(correct + " answers out of 5 are correct.");
	}
	
	public static int divide(int m, int n) {
		int count = 0;
		
		while (m >= n) {
			m -= n;
			count++;
		}
		return count;
	}
	
	public static int modulus(int m, int n) {
		while (m >= n) {
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
	
}
