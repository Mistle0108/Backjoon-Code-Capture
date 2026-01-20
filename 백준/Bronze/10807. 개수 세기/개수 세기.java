import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in); 

		int count = sc.nextInt();
		sc.nextLine();
		
		int[] numArray = new int[count];
		
        for (int i = 0; i < count; i++) {
        	numArray[i] = sc.nextInt();
		}
        sc.nextLine();
        
        int findNum = sc.nextInt();
        
        int findCount = 0;
        
        for (int i = 0; i < count; i++) {
        	if(numArray[i] == findNum) findCount++;
		}
        
        System.out.println(findCount);
	}	
}