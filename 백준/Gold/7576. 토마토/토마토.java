import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); // 열
        int N = Integer.parseInt(input[1]); // 행

        int[][] arr = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);

                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currY = curr[0];
            int currX = curr[1];

            for (int k = 0; k < 4; k++) {
                int nextY = currY + dy[k];
                int nextX = currX + dx[k];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (arr[nextY][nextX] == 0) {
                    arr[nextY][nextX] = arr[currY][currX] + 1;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }

        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
                maxDay = Math.max(maxDay, arr[i][j]);
            }
        }

        bw.write(String.valueOf(maxDay - 1));
        bw.flush();
    }
}