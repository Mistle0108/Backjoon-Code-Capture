import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sc.nextLine();
		
		String[] tArray = new String[t];
		
		for(int i=0; i<t; i++) {
			tArray[i] = sc.nextLine();
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(""+ tArray[i].charAt(0) + tArray[i].charAt(tArray[i].length()-1));
		}
	}	
}