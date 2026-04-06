import java.io.*;
import java.util.*;

class Main {
	static int N, M;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
            	arr[i][j] = line.charAt(j) - '0';
            }
        }
		bw.write(bfs() + "");
		
		bw.flush();
	}
	
	static int bfs() {

		Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[2][N][M];
        
        visited[0][0][0] = true;
        queue.add(new int[]{0, 0, 1, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            int broken = curr[3];

            if (x == N - 1 && y == M - 1) return dist;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

                if (arr[nextX][nextY] == 0) {
                    if (!visited[broken][nextX][nextY]) {
                        visited[broken][nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, dist + 1, broken});
                    }
                } else if (broken == 0) {
                    if (!visited[1][nextX][nextY]) {
                        visited[1][nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, dist + 1, 1});
                    }
                }
            }
        }
        return -1;
    }
}
