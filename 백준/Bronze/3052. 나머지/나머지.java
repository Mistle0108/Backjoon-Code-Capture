
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
				
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			int input = sc.nextInt();
			set.add(input%42);
		}
		
		System.out.println(set.size());
	}	
}