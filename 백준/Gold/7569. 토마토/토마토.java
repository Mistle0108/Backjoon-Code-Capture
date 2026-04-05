import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] dx = { 1, -1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, 1, -1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };

		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		int H = Integer.parseInt(input[2]);

		int[][][] arr = new int[H][N][M];// zyx
		Queue<int[]> queue = new LinkedList<>();

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					arr[k][i][j] = Integer.parseInt(temp[j]);

					if (arr[k][i][j] == 1) {
						queue.add(new int[] { k, i, j });
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currZ = curr[0];
			int currY = curr[1];
			int currX = curr[2];

			for (int k = 0; k < 6; k++) {
				int nextZ = currZ + dz[k];
				int nextY = currY + dy[k];
				int nextX = currX + dx[k];

				if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || nextZ < 0 || nextZ >= H) {
					continue;
				}

				if (arr[nextZ][nextY][nextX] == 0) {
					arr[nextZ][nextY][nextX] = arr[currZ][currY][currX] + 1;
					queue.add(new int[] { nextZ, nextY, nextX });
				}
			}
		}

		int maxDay = 0;

		for (int k = 0; k < H; k++) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[k][i][j] == 0) {
						bw.write("-1");
						bw.flush();
						return;
					}
					maxDay = Math.max(maxDay, arr[k][i][j]);
				}
			}
		}

		bw.write(String.valueOf(maxDay - 1));
		bw.flush();
	}
}