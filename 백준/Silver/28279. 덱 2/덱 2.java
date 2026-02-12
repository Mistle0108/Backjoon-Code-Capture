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
        
        MyDequeue mdq = new MyDequeue(input); 
        
        for (int i = 0; i < input; i++) {
        	String[] temp = br.readLine().split(" ");
        	
        	int oper = Integer.parseInt(temp[0]);
        	
        	if(oper == 1) {
        		mdq.push_front(Integer.parseInt(temp[1]));
        	}else if(oper == 2) {
        		mdq.push_back(Integer.parseInt(temp[1]));
        	}else if(oper == 3) {
        		bw.write(mdq.pop_front() + "\n");
        	}else if(oper == 4) {
        		bw.write(mdq.pop_back() + "\n");
        	}else if(oper == 5) {
        		bw.write(mdq.size() + "\n");
        	}else if(oper == 6) {
        		bw.write((mdq.isEmpty() ? "1":"0") + "\n");
        	}else if(oper == 7) {
        		bw.write(mdq.front() + "\n");
        	}else if(oper == 8) {
        		bw.write(mdq.back() + "\n");
        	}
		}
        
        
        bw.write("");
        
        bw.flush();
        
        br.close();
        bw.close();
	}
	
	static class MyDequeue{
		int right = 0;
		int left = 0;
		int capacity = 1000000;
		int size = 0;
		
		
		private int[] space;
		
		public MyDequeue() {
			space = new int[capacity];
		}
		
		public MyDequeue(int capacity) {
			this.capacity = capacity;
				
			space = new int[capacity];
		}
		
		
		
		void push_front(int input) {
			size++;
			left = (left - 1 + capacity) % capacity;
			space[left] = input;
		}
		
		void push_back(int input) {
			size++;
			space[right] = input;
			right = (right + 1 + capacity) % capacity;
		}
		
		int pop_front() {
			
			if(size != 0) {
				size--;
				int value = space[left];
				left = (left + 1 + capacity) % capacity;
				return value;
			}else {
				return -1;
			}
		}
		
		int pop_back() {
			if(size != 0) {
				size--;
				right = (right - 1 + capacity) % capacity;
				int value = space[right];
				return value;
			}else {
				return -1;
			}
		}
		
		int size() {
			return size;
		}
		
		
		boolean isEmpty() {
			return (size == 0);
		}
		
		int front() {
		    if (isEmpty()) return -1;
		    return space[left];
		}

		int back() {
		    if (isEmpty()) return -1;
		    return space[(right - 1 + capacity) % capacity];
		}
		
	}
	
}