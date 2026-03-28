
import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        MaxHeap mp = new MaxHeap(N);
        
        for (int i = 0; i < N; i++) {
        	String[] temp = br.readLine().split(" ");
        	for (int j = 0; j < temp.length; j++) {
        		mp.insert(Integer.parseInt(temp[j]));
			}
        }
        
        int k = 0;
        for (int i = 0; i < N; i++) {
        	if(i == N-1) bw.write(mp.delete()+"");
        	else mp.delete();
		}
        
        
        bw.flush();
        br.close();
        bw.close();
    }

    public static class MaxHeap{
    	private int[] heap;
    	private int size;
    	
    	public MaxHeap(int capacity) {
    		this.heap = new int[capacity + 1];
    		this.size = 0;
    	}
    	
    	public void insert(int value) {
    		if(size == heap.length-1) {
    			
    			heap = Arrays.copyOf(heap, heap.length*2);
    		}
    		
    		int current = ++size;
   
    		while(current > 1 && value > heap[current/2]) {
    			heap[current] = heap[current/2];
    			current = current/2;
    		}
    		heap[current] = value;
    	}
    	
    	public int delete() {
    		if(size == 0) {
    			return -1;
    		}
    		
    		int root = heap[1];   		
    		int lastNode = heap[size];
    		heap[size--] = 0;
    		
    		int current = 1;
    		int child;
    		
    		while((child = current *2) <= size) {
    			
    			if((child + 1) <= size && heap[child + 1] > heap[child]) {
    				child++;
    			}
    			
    			if(lastNode >= heap[child]) break;
    			
    			heap[current] = heap[child];
    			current = child;
    		}
    		heap[current] = lastNode;
    		
    		return root;
    	}
    	
    	public int getSize() {
    		return this.size;
    	}
    }
}