import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        MaxHeap mp = new MaxHeap(N);
        
        for (int i = 0; i < N; i++) {
        	int temp = Integer.parseInt(br.readLine());
        	if(temp == 0) {
        		if(mp.getSize() == 0) bw.write("0\n"); 
        		else bw.write(mp.delete() + "\n");
        	} else {
        		mp.insert(temp);
        	}
        	
        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    // 우선순위 큐는 완전 이진 트리로 구현한다
    // 맥스힙은 부모 노드가 자식노드보다 크거나 같아야 한다
    public static class MaxHeap{
    	private int[] heap;
    	private int size;
    	
    	public MaxHeap(int capacity) {
    		this.heap = new int[capacity + 1];
    		this.size = 0;
    	}
    	
    	// 가장 하단에서부터 탐색해나간다.
    	public void insert(int value) {
    		if(size == heap.length-1) {
    			// 분할 상환 시간 복잡도(Amortized Time Complexity)
    			heap = Arrays.copyOf(heap, heap.length*2);
    		}
    		
    		int current = ++size;
    		
    		// current > 1 (비교할 값을 제외한 데이터가 있고)
    		// && 입력된 값이 현재 자신(최초는 가장 끝 값)이 부모보다 큰 지 체크하여 맞다면
    		
    		// 부모의 값을 내리고 새로운 값을 부모 자리로 교체해준다
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
    		
    		// 최대 값을 임시 저장
    		int root = heap[1];
    		
    		// 가장 작은 값을 보관해두고
    		int lastNode = heap[size];
    		
    		// 해당 자리를 비움
    		heap[size--] = 0;
    		
    		int current = 1;
    		int child;
    		
    		
    		// 남아있는 자식이 있는 동안 계속해서 내려간다
    		while((child = current *2) <= size) {
    			
    			// (child + 1) <= size: 오른쪽 자식이 있고 
    			// && 왼쪽 자식보다 크다면
    			
    			// 오른쪽 자식을 선택한다.
    			if((child + 1) <= size && heap[child + 1] > heap[child]) {
    				child++;
    			}
    			
    			// 마지막 노드가 자식보다 크거나 같다면 종료
    			if(lastNode >= heap[child]) break;
    			
    			// 자식 값을 부모 자리로 올린다
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