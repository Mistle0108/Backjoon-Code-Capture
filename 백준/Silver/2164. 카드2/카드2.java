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
           	
        MyQueue mq = new MyQueue(1000000);
        
        for (int i = 1; i <= input; i++) {
			mq.push(i);
		}
        
        int k = 0;
        while(true) {
        	int mqs = mq.size(); 
        	if(mqs == 1) { 
        		bw.write(mq.pop() +""); 
        		break;
        	}
        	k++;
        	
        	if(k%2 == 1) {
        		mq.pop();
        	} else {
        		int temp = mq.pop();
        		mq.push(temp);
        	}
        	
        }
        
    	  
        bw.flush();
        
        br.close();
        bw.close();
	}
	
static class MyQueue{
		
		private int front = 0;
		private int rear = 0;
		
		private int size = 0;
		
		private int[] space;
		
		public MyQueue() {
			space = new int[100];
		}
		
		public MyQueue(int size) {
			space = new int[size];
		}
		
		void push(int input) {
			space[rear++] = input;
		}
	
		int pop() {
			return space[front++];
		}
		
		int size() {
			return rear - front;
		}
		
		boolean isEmpty() {
			return front == rear;
		}
		
		int front() {
			if(isEmpty()) {
				return -1;
			}else {
				return space[front];
			}
			
		}
		
		int back() {
			if(isEmpty()) {
				return -1;
			}else {
				return space[rear-1];
			}
		}
		
	}
	
	
}