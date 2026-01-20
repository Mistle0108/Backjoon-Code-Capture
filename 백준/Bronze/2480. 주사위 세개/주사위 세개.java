import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[3];
		
		int dice1 = sc.nextInt();
		int dice2 = sc.nextInt();
		int dice3 = sc.nextInt();
		
		int total = 0;
		
		if(dice1 == dice2 && dice1 == dice3) {
			total = 10000 + dice1 * 1000;
		}else if(dice1 == dice2){
			total = 1000 + dice1 * 100;
		}else if(dice1 == dice3){
			total = 1000 + dice1 * 100;
		}else if(dice2 == dice3){
			total = 1000 + dice2 * 100;
		}else {
			if(dice1 >= dice2) {
				if(dice1 >= dice3) total =  dice1 * 100;
				else total =  dice3 * 100;
			}else  {
				if (dice2 >= dice3) total =  dice2 * 100;
				else total =  dice3 * 100;
			}
		}
	
		
		System.out.println(total);
	}	
}