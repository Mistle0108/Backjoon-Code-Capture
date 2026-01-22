import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		String t = sc.nextLine();
		
		int total = 0;
		for(int i = 0; i <t.length(); i++) {
			total += Integer.parseInt(t.substring(i,i+1));
		}
		System.out.println(total);
	}	
}