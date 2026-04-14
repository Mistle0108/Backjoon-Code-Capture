import java.io.*;
import java.util.*;

public class Main {

	static class Node  implements Comparable<Node> {
		int index;
		int distance;

		Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		 @Override
		    public int compareTo(Node o) {
		        return this.distance - o.distance;
		    }
	}
	static ArrayList<Node>[] graph;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		String[] input = br.readLine().split(" ");
		
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);

		dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
		
		for (int i = 0; i < E; i++) {
			String[] temp = br.readLine().split(" ");

			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);

			dist[a][b] = c;
		}

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                	if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                	
                	if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                	}
                 }
            }
        }
		
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, dist[i][i]);
        }
        
        if(answer == Integer.MAX_VALUE) {
        	bw.write( -1 + "");
        } else {
        	bw.write(answer+"");
        }        

		bw.flush();
		bw.close();
		br.close();
	}
}
