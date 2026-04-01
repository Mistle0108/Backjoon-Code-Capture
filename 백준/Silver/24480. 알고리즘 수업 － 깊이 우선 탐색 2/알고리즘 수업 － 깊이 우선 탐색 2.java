import java.io.*;
import java.util.*;

class Main {

	static ArrayList<Integer>[] graph;
    static int[] order;
    static boolean[] visited;
    static int count = 1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
       
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        
        order = new int[N + 1];
        visited = new boolean[N + 1];
        
        dfs(R);
        
        for (int i = 1; i <= N; i++) {
        	bw.write(order[i] + "\n");
		}
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void dfs(int node) {
        visited[node] = true;
        order[node] = count++;

        for (int i = 0; i < graph[node].size(); i++) {
            int next = graph[node].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}