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
           	
        MyQueue mq = new MyQueue(input);
        
        for (int i = 0; i < input; i++) {
			String[] temp = br.readLine().split(" ");
			
			if(Objects.equals(temp[0], "push")) {
				mq.push(Integer.parseInt(temp[1])); 
			}else if(Objects.equals(temp[0], "pop")) {
				bw.write(mq.isEmpty() ? "-1\n" : mq.pop()+"\n");
			}else if(Objects.equals(temp[0], "size")) {
				bw.write(mq.size() +"\n");
			}else if(Objects.equals(temp[0], "empty")) {
				bw.write(mq.isEmpty() ? "1\n" : "0\n");
			}else if(Objects.equals(temp[0], "front")) {
				bw.write(mq.front() +"\n");
			}else if(Objects.equals(temp[0], "back")) {
				bw.write(mq.back() +"\n");
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