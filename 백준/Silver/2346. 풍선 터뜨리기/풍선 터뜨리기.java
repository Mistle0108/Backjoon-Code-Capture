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
        
        MyDequeue dq = new MyDequeue();
        
        int[] num = new int[input];	// 풍선 번호 배열
        int[] arr = new int[input];	// 풍선 이동 값 배열
        
        // 풍선 번호 배열 초기화
        for (int i = 0; i < input; i++) { 
        	num[i] = i+1;
		}
        
        // 풍선 이동 값 입력
        String[] temp = br.readLine().split(" ");
        
        // 풍선 이동 값 배열 초기화
        for (int i = 0; i < input; i++) { 
        	arr[i] = Integer.parseInt(temp[i]);
        }

        // dq에 풍선 배치
        for (int i = 0; i < input; i++) {
        	dq.push_back(num[i]);
        }
       
        // 첫 풍선 pop()
        bw.write(dq.pop_front() + " "); 
 
        // 첫 번째 풍선 인덱스로 초기화 
        int idx = arr[0];
        
        // 마지막 풍선에 의한 이동은 없으므로 풍선 수에서 1회 차감
        for (int i = 0; i < input - 1; i++) {

        	// 터트린 풍선의 이동 값만큼 회전
        	if(idx > 0) {
        		int move = (idx - 1) % dq.size;
	        	for (int j = 0; j < move; j++) {
	        		dq.push_back(dq.pop_front());
				}	
        	} else {
        		int move = Math.abs(idx) % dq.size;
        		// 음수인 경우 절대값을 사용
        		for (int j = 0; j < move; j++) {
        			dq.push_front(dq.pop_back());
				}
        	}
        	
        	// 터트릴 풍선
        	int bustedBalloon = dq.pop_front();
        	// 터트릴 풍선의 이동 값
        	idx = arr[bustedBalloon - 1];
        	
        	bw.write(bustedBalloon + " ");
		}
        
        bw.flush();
        
        br.close();
        bw.close();
	}
	
	static class MyDequeue{
				
		Node head;
		Node tail;
		int size;
		
		void push_front(int value) {
			Node newNode = new Node(value);
			if(size == 0) {
				head = tail = newNode;
			}
			else {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			}
			size++;
		}
		
		void push_back(int value) {
			Node newNode = new Node(value);
			if(size == 0) {
				head = tail = newNode;
			}
			else {
				newNode.prev = tail;
				tail.next = newNode;
				tail = newNode;
			}
			size++;
		}
		
		public int pop_front() {
			if (size == 0) return -1;
			
			int value = head.data;
			head = head.next;
			
			if(head == null) tail = null;
			else head.prev = null;
			size--;
			return value;
		}
		
		public int pop_back() {
			if (size == 0) return -1;
			
			int value = tail.data;
			tail = tail.prev;
			
			if(tail == null) head = null;
			else tail.next = null;
			size--;
			return value;
		}
		

	}
	static class Node{
		Node prev;
		Node next;
		int data;
		Node(int data){
			this.data = data;
		}
	}
}