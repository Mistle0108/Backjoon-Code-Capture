import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
				
		int[] students = new int[30];
		
		for(int i = 1; i <= 28; i++) {
			int num = sc.nextInt();
			sc.nextLine();
			
			students[num-1] = 1;
		}
		
		for (int i = 0; i < students.length; i++) {
			if(students[i] == 0) {
				System.out.println(i+1);
			}
		}
		
				
	}	
}