import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int basketCount = sc.nextInt();
		int Round = sc.nextInt();
		sc.nextLine();
		
		int[] basketArray = new int[basketCount];
		
		for(int i = 0; i < basketCount; i++) {
			basketArray[i] = i + 1;
		}
		
		
		
		for (int t = 0; t < Round; t++) {
			int i = sc.nextInt() - 1;
			int j = sc.nextInt() - 1;
		
			int temp = 0;
			
			temp = basketArray[i];
			basketArray[i] = basketArray[j];
			basketArray[j] = temp;
		
		}
		
		for (int i = 0; i < basketCount; i++) {
			System.out.print(basketArray[i] + " ");
		}
				
	}	
}