import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int[] indegree = new int[N+1];
        
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
        	String[] temp = br.readLine().split(" ");
        	int a = Integer.parseInt(temp[0]);
        	int b = Integer.parseInt(temp[1]);
        	
        	graph[a].add(b);
        	indegree[b]++;
		}
        
        PriorityQueue<Integer> queue = new PriorityQueue();
        
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
            	queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            bw.write(curr + " ");

            for (int next : graph[curr]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                	queue.add(next);
                }
            }
        }
        
        bw.flush();
        bw.close();
    }
}