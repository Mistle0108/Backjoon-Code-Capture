import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        int nowYear = sc.nextInt();
        
        int yearGap = 2541 - 1998;
        		
        System.out.println(nowYear - yearGap);
	}	
}