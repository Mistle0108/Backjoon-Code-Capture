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

        while(true) {
        	String input = br.readLine();
        	
        	if(Objects.equals(input,".")) break;
        	
        	Stack stack = new Stack();
        	
        	boolean isOver = false;
        	
        	for (int i = 0; i < input.length(); i++) {
        		
        		if(input.charAt(i) == '(') {
        			stack.push(1);
        		} else if(input.charAt(i) == ')') {
        			if(stack.peak() != 1 || stack.isEmpty()) {
        				isOver = true;
        				break;
        			}
        			else stack.pop();
        			
        		} else if(input.charAt(i) == '[') {
        			stack.push(2);
        		} else if(input.charAt(i) == ']') {
        			if(stack.peak() != 2 || stack.isEmpty()) { 
        				isOver = true;
        				break;
        			}
        			else stack.pop();
        		}
			}
        	
        	if (!stack.isEmpty()) {
        		isOver = true;
            }
        	
        	if(!isOver) {
        		bw.write("yes\n");
        	}else {
        		bw.write("no\n");
        	}
        	
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