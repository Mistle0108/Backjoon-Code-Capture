import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in); 

		int n = sc.nextInt();
		int x = sc.nextInt();
		
		sc.nextLine();
		
		int[] nArray = new int[n];
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			nArray[i] = sc.nextInt();
			if(nArray[i] < x) list.add(nArray[i]);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}	
}