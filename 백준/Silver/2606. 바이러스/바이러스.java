import java.io.*;
import java.util.*;

class Main {

	static ArrayList<Integer>[] graph;
    static int[] order;
    static boolean[] visited;
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
        	String[] input = br.readLine().split(" ");
        	
        	int u = Integer.parseInt(input[0]);
        	int v = Integer.parseInt(input[1]);
        	
        	graph[u].add(v);
        	graph[v].add(u);
		}
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        order = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);
        
        bfs(1);
        
        bw.write(count + "");

        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void bfs(int node) {
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	visited[node] = true;
    	queue.add(node);
        
        while(!queue.isEmpty()) {
        	int next = queue.poll();
        	
        	for (int i = graph[next].size()-1; i >= 0; i--) {
        	    int linked = graph[next].get(i);
        	    
        	    if (!visited[linked]) {
        	        visited[linked] = true;
        	        count++;
        	        queue.add(linked);
        	    }
        	}
        }
    }
}
