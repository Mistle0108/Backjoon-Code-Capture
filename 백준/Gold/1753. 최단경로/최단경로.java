import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node>{
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
	
	static final int INF = Integer.MAX_VALUE;
	static int[] d;
	static ArrayList<Node>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		
		int K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];  
		for (int i = 0; i < V+1; i++) {
			graph[i] = new ArrayList();
		}

		for (int i = 0; i < E; i++) {
			String[] temp = br.readLine().split(" ");
			
			int u = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);
			int w = Integer.parseInt(temp[2]);
			
			graph[u].add(new Node(v,w));
		}

		d = new int[V+1];		
		Arrays.fill(d, INF);
			
		dijkstra(K);
		
		// 출력 로직 추가
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (d[i] == INF) sb.append("INF\n");
            else sb.append(d[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
		
    }
    
    static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<Node>();
    	
    	pq.add(new Node(start, 0));
    	d[start] = 0;
    	
    	while(!pq.isEmpty()) {
    		
    		Node node = pq.poll();
    		
    		int index = node.index;
    		int distance = node.distance;
    		
    		if(d[index] < distance) continue;
    		
    	    for(Node next : graph[index]) {
    	    	
    	    	int cost = d[index] + next.distance;
    	    	
    	    	if(cost < d[next.index]) {
    	    		d[next.index] = cost;
    	    		pq.add(new Node(next.index, cost));
    	    	}
    	    }
    	}	
    }
}