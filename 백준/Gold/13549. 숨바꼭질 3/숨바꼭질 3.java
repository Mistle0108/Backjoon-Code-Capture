import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.distance, other.distance);
		}
	}
	
	static int[] d = new int[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		dijkstra(N);
	
		bw.write(d[K] + "");
		
	    bw.flush();
        bw.close();
        br.close();
		
    }
    
    static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.add(new Node(start, 0));
    	
    	while(!pq.isEmpty()) {
    		Node current = pq.poll();
            int currIdx = current.index;
            int currDist = current.distance;
            
            if (d[currIdx] < currDist) continue;
            
            int[] weights = {1, 1, 0};
            int[] next = {currIdx+1, currIdx-1, currIdx*2};
    		
            for (int j = 0; j < 3; j++) {
				int nextIdx = next[j]; 
			
    			if(nextIdx >= 0 && nextIdx <= 100000) {
    				if(d[nextIdx] > d[currIdx] + weights[j]) {
    					d[nextIdx] = d[currIdx] + weights[j];
    					pq.add(new Node(nextIdx, d[nextIdx]));
    				}
    				
    			}
    			
			}
    	}
    	
    }
}

