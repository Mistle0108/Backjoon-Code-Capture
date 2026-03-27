import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        MinHeap mp = new MinHeap(N);
        
        for (int i = 0; i < N; i++) {
        	int temp = Integer.parseInt(br.readLine());
        	if(temp == 0) {
        		if(mp.getSize() == 0) bw.write("0\n"); 
        		else bw.write(mp.poll() + "\n");
        	} else {
        		mp.add(temp);
        	}
        	
        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    // 우선순위 큐는 완전 이진 트리로 구현한다
    // 맥스힙은 부모 노드가 자식노드보다 작거나 같아야 한다
    public static class MinHeap{
    	private int[] heap;
    	private int size;
    	
    	public MinHeap(int capacity) {
    		this.heap = new int[capacity + 1];
    		this.size = 0;
    	}
    	
    	// Up-Heap
    	public void add(int value) {
    		if(size == heap.length) {
    			// 분할 상환 시간 복잡도(Amortized Time Complexity)
    			heap = Arrays.copyOf(heap, heap.length*2);
    		}
    		
    		// 들어오는 값을 가장 마지막에 넣는다.
    		heap[size] = value;
    		int i = size;
    		size++;
    		
    		// 부모와 비교하며 위로 올라간다
    		// 부모가 나보다 크면 swap
    		while(i > 0) {
    			
    			// 부모의 인덱스 계산
    			int parent = (i-1)/2;
    			
    			// 부모 값이 나보다 작거나 같으면 중단
    			if (Math.abs(heap[parent]) < Math.abs(heap[i])) break;
    		    if (Math.abs(heap[parent]) == Math.abs(heap[i]) && heap[parent] <= heap[i]) break;
    		
    			// 그렇지 않다면 swap
    			swap(i, parent);
    			i = parent;
    		}
    	}
    	
    	// Down-Heap
        public int poll() {
            if (size == 0) return 0;

            int root = heap[0];
            heap[0] = heap[size - 1]; // 마지막 노드를 루트로 이동
            size--;

            int i = 0;
        	
            if (size > 0) {
            	while (true) {
            		int smallest = i;
                    int left = 2 * i + 1;
                    int right = 2 * i + 2;

                    // 왼쪽 자식이 나보다 작다면 갱신
                    if (left < size) {
                        if (Math.abs(heap[left]) < Math.abs(heap[smallest]) || 
                           (Math.abs(heap[left]) == Math.abs(heap[smallest]) && heap[left] < heap[smallest])) {
                            smallest = left;
                        }
                    }

                    // 오른쪽 자식이 현재 smallest보다 더 작다면 갱신
                    if (right < size) {
                        if (Math.abs(heap[right]) < Math.abs(heap[smallest]) || 
                           (Math.abs(heap[right]) == Math.abs(heap[smallest]) && heap[right] < heap[smallest])) {
                            smallest = right;
                        }
                    }

                    // 더 이상 내려갈 곳이 없으면 중단
                    if (smallest == i) break;

                    swap(i, smallest);
                    i = smallest;
                }
            }
            return root;
        }
    	
    	public int getSize() {
    		return this.size;
    	}
    	
    	private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
}