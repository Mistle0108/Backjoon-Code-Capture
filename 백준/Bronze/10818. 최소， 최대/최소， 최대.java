import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in); 

		int n = sc.nextInt();
		
		sc.nextLine();
		
		int[] nArray = new int[n];
		
		int max = 0;
		int min = 0;
		
		for (int i = 0; i < n; i++) {
			nArray[i] = sc.nextInt();
		
			if(i == 0) {
				max = nArray[i];
				min = nArray[i];
			} 
			
			if(nArray[i] > max) max = nArray[i];
			if(nArray[i] < min) min = nArray[i];
		}
		
		System.out.println(min + " " + max);
	}	
}