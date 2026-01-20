import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int expectedByte= sc.nextInt();
		
		String result = "int";
		
		for(int i = 0 ; i < expectedByte/4; i ++) {
			result = "long " + result;
		}
		
		System.out.println(result);
	}	
}