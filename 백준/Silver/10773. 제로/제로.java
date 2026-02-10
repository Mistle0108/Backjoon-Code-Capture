import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        
        Stack stack = new Stack();
        
        for (int i = 0; i < input; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			if(temp == 0) {
				stack.pop();
			} else {
				stack.push(temp);
			}
		}
        
        int count = 0;
        
        while(stack.isEmpty() == 0) {
        	count += stack.pop();
        }
        
        bw.write(count + "");
        
        
        bw.flush();
        
        br.close();
        bw.close();
	}
	
	static class Stack{
		
		int pointer = -1;
		
		private int[] space;
		
		public Stack() {
			space = new int[1000000];
		}
		
		int pop() {
			if(isEmpty() ==  0) {
				return space[pointer--];
			}else {
				return -1;
			}
		}
		
		void push(int input) {
			space[++pointer] = input;
		}
		
		int isEmpty() {
			if(pointer != -1) {
				return 0;
			}else {
				return 1;
			}
		}
		
		int size() {
			return pointer + 1;
		}
		
		int peak() {
			if(isEmpty() == 0) {
				return space[pointer]; 
			}else {
				return -1;
			}
		}
		
	}
	
}