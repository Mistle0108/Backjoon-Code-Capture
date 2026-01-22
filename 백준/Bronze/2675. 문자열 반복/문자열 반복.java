import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
			
		String[] tArray = new String[t]; 

		for(int i = 0; i < t; i++) {	
			int r = sc.nextInt();
			String s = sc.nextLine().trim();
			
			
			tArray[i] = "";
			
			for(int k = 0; k < s.length(); k++) {
				for(int j = 0; j < r; j++) {
					tArray[i] += s.charAt(k);					
				}
			}
		}
		
		for(int i = 0; i < t; i++) {
			System.out.println(tArray[i]);
		}	
	}	
}