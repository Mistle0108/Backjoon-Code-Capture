import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int basketCount = sc.nextInt();
		int Round = sc.nextInt();
		sc.nextLine();
		
		int[] basketArray = new int[basketCount];
		
		for (int t = 0; t < Round; t++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			for(int l = i; l <= j; l++) {
				basketArray[l-1] = k;
			}
		}
		
		for (int i = 0; i < basketCount; i++) {
			System.out.print(basketArray[i] + " ");
		}
				
	}	
}