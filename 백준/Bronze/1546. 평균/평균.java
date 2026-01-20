
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		float[] nArray = new float[n]; 
		
		float max = 0;
		
		for(int i = 0 ; i < n; i++) {
			nArray[i] = sc.nextInt();

			if(i == 0) max = nArray[i];
			
			if(nArray[i] > max) max = nArray[i];
		}
		
		float total = 0;
		
		for(int i = 0 ; i < n; i++) {
			total += nArray[i]/max * 100;
		}
		
		System.out.println(total/n);		
	}	
}