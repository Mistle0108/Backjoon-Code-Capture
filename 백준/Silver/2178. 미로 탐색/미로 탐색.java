import java.io.*;
import java.util.*;

class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    static int[] dist;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        int size = N * M;
        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
        
        graph = new ArrayList[size];
        for (int i = 0; i < size; i++) {
    		graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (arr[i][j] == 0) continue;

                int u = i * M + j;
                int[] near = checkNearNumber(i, j);

                for (int v : near) {
                    if (v != -1) {
                        graph[u].add(v);
                    }
                }
            }
        }
        
        visited = new boolean[size];
        Arrays.fill(visited,false);
        
        dist = new int[size];
        
        bfs(0);
        
        bw.write(dist[size -1] +"");        
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int startNode) {
    	Queue<Integer> queue =  new LinkedList<Integer>();
    	
    	visited[startNode] = true;
    	dist[startNode] = 1;
    	queue.add(startNode);
    	
    	while(!queue.isEmpty()) {
    		int current = queue.poll();
    		
    		for (int i = 0; i < graph[current].size(); i++) {
    			int next = graph[current].get(i);
    			
    			if(!visited[next]) {
    				visited[next] = true;
    				dist[next] = dist[current] + 1;
    				queue.add(next);
    			}
				
			}
    		
    	}
    }
    
    static int[] checkNearNumber(int x, int y) {
        int[] temp = new int[4];
        int idx = 0;

        if (x + 1 < N && arr[x + 1][y] == 1) {
            temp[idx++] = (x + 1) * M + y;
        } else temp[idx++] = -1;

        if (x - 1 >= 0 && arr[x - 1][y] == 1) {
            temp[idx++] = (x - 1) * M + y;
        } else temp[idx++] = -1;

        if (y + 1 < M && arr[x][y + 1] == 1) {
            temp[idx++] = x * M + (y + 1);
        } else temp[idx++] = -1;

        if (y - 1 >= 0 && arr[x][y - 1] == 1) {
            temp[idx++] = x * M + (y - 1);
        } else temp[idx++] = -1;

        return temp;
    }

}
