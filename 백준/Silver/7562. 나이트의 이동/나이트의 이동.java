import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] dx = {1, 1 ,-1, -1, 2, 2, -2, -2};
		int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			String[] start = br.readLine().split(" ");
			String[] end = br.readLine().split(" ");

			int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);

            int endX = Integer.parseInt(end[0]);
            int endY = Integer.parseInt(end[1]);

			boolean[][] visited = new boolean[N][N];
			int[][] dist = new int[N][N];
			
			Queue<int[]> queue = new LinkedList<>();
			visited[startX][startY] = true;

			queue.add(new int[]{startX, startY});
			
			while (!queue.isEmpty()) {
				int[] next = queue.poll();
				int x = next[0];
                int y = next[1];

				if (x == endX && y == endY) break;
				
				for (int j = 0; j < 8; j++) {
					int nextX = x + dx[j];
					int nextY = y + dy[j];
					
					if(nextX >= N || nextY >= N || nextX < 0 || nextY < 0) continue;
					
					if(!visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						dist[nextX][nextY] = dist[x][y] + 1;
						queue.add(new int[]{nextX, nextY});
					}
					
				}
			}
			bw.write(dist[endX][endY] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
