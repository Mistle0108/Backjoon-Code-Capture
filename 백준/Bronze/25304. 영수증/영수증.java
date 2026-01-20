import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int totalPrice = sc.nextInt();
		sc.nextLine();
		int totalCount = sc.nextInt();
		
		int CalculatedPrice = 0;
		
		int [] itemPrice = new int[totalCount];
		int [] itemCount = new int[totalCount];
		
		for (int i = 0; i < totalCount; i++) {
			itemPrice[i] = sc.nextInt();
			itemCount[i] = sc.nextInt();
			
			CalculatedPrice += itemPrice[i] * itemCount[i];
		}
		
		if(totalPrice == CalculatedPrice) System.out.println("Yes");
		else System.out.println("No");
		
	}	
}