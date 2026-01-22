import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		a = a/100 + a%10 * 100 + a%100-a%10;
		b = b/100 + b%10 * 100 + b%100-b%10;
		
		if(a > b) {
			System.out.println(a);
		}else {
			System.out.println(b);
		}
		
	}	
}