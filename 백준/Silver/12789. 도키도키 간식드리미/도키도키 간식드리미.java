
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
        
        String [] nArr = br.readLine().split(" ");
        
        Stack stack = new Stack(input);
    	
    	int needPopIdx = 1; 
    	
    	for (int i = 0; i < input; i++) {
			int current = Integer.parseInt(nArr[i]);
			
			if(current == needPopIdx) {
				needPopIdx++;
			}else {
				stack.push(current);
			}
			
			while(!stack.isEmpty() && stack.peak() == needPopIdx) {
				stack.pop();
				needPopIdx++;
			}
		}
    	
		
		if (stack.isEmpty()) {
		    bw.write("Nice");
		} else {
			bw.write("Sad");
		}
    	
    	  
        bw.flush();
        
        br.close();
        bw.close();
	}

	static class Stack{
		
		public int pointer = -1;
		
		private int[] space;
		
		public Stack() {
			space = new int[100];
		}
		public Stack(int size) {
			space = new int[size];
		}
		
		int pop() {
			if(isEmpty()) {
				return -1;
			} else {
				return space[pointer--];
			}
		}
		
		void push(int input) {
			space[++pointer] = input;
		}
		
		boolean isEmpty() {
			if(pointer != -1) {
				return false;
			}else {
				return true;
			}
		}
		
		int size() {
			return pointer + 1;
		}
		
		int peak() {
			if(isEmpty()) {
				return -1;
			}else {
				return space[pointer];
			}
		}
		
		void clear() {
			pointer = -1;
		}
	}
	
}