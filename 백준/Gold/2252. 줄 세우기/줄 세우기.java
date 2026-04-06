import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] weight = new int[N + 1];
		
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
		    graph[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().split(" ");
			
			graph[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
			weight[Integer.parseInt(temp[1])]++;
			
		}
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
            if (weight[i] == 0) {
            	queue.offer(i);
            }
        }
		
		while (!queue.isEmpty()) {
            int curr = queue.poll();
            bw.write(curr + " ");

            for (int next : graph[curr]) {
                weight[next]--;

                if (weight[next] == 0) {
                    queue.offer(next);
                }
            }
        }
		
		bw.flush();
	}
	
}
