import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		
		int[] nArray = new int[9];
		
		int max = 0;
		int maxIdx = 0;
		
		for (int i = 0; i < 9; i++) {
			nArray[i] = sc.nextInt();
			
			if(i == 0) max = nArray[i];
			
			if(nArray[i] > max) {
				
				max = nArray[i];
				maxIdx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(maxIdx + 1);
		
	}	
}