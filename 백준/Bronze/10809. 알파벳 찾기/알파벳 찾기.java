import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		
		int [] alphabet = new int[26];
		
		for(int i = 0; i < 26; i++) {
			alphabet[i] = n.indexOf(i+97);
		}
		
		for(int i = 0; i <alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}	
}