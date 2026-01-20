import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		sc.nextLine();
		
		int[] nArray = new int[n];
		
		for(int i = 0; i < nArray.length; i++) {
			nArray[i] = i+1;
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			for(int k = 0; k < (b - a + 1)/2; k++) {
				int temp = 0;
				
				temp = nArray[a+k];
				nArray[a+k] = nArray[b-k];
				nArray[b-k] = temp;
			}
			
		}
		
		for(int i = 0; i < nArray.length; i++) {
			System.out.print(nArray[i] + " ");
		}
	}	
}