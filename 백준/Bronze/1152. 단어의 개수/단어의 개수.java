import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine().trim();
			
		String [] splitString = s.split(" ");
		
		int count = splitString.length;
		
		for(int i = 0; i < splitString.length; i++) {
			if(splitString[i] == "") count--; 
		}

		System.out.println(count);
	
	}	
}