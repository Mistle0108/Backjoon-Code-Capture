import java.io.*;
import java.util.*;

class Main {
	static int[] ladder = new int[101];
	static int[] snake  = new int[101];
	static boolean[] visited = new boolean[101];
	static int[] dist = new int[101];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			int u = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);
			ladder[u] = v; 
		}
		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().split(" ");
			int u = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);
			snake[u] = v;	
		}
		
		 
		Arrays.fill(visited,false);
		
		bfs(1);

		bw.write(dist[100] -1 + "");
		
		bw.flush();
	}
	
	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
        visited[node] = true;
        dist[node] = 1;
        queue.add(node);
        
        while(!queue.isEmpty()) {
        	int curr = queue.poll(); 
        	
        	for (int i = 1; i <= 6; i++) {
				
        		int next = curr + i; 
        		
        		if (next > 100) continue;
        		
        		if(ladder[next] != 0) {
        			next = ladder[next];
        		}else if(snake[next] != 0) {
        			next = snake[next];
        		}
        		
        		
        		if(!visited[next]) {
        			visited[next] = true;
        			dist[next] = dist[curr] + 1;
        			queue.add(next);
        		}
			}
        	
        }
        
    }
}