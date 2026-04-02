
import java.io.*;
import java.util.*;

class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");

            M = Integer.parseInt(input[0]); // 가로
            N = Integer.parseInt(input[1]); // 세로
            int K = Integer.parseInt(input[2]);

            int[][] arr = new int[N][M];

            for (int i = 0; i < K; i++) {
                String[] pos = br.readLine().split(" ");
                int x = Integer.parseInt(pos[0]);
                int y = Integer.parseInt(pos[1]);

                arr[y][x] = 1;
            }

            int size = N * M;

            graph = new ArrayList[size];
            for (int i = 0; i < size; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) continue;

                    int u = i * M + j;
                    int[] near = checkNearNumber(i, j, arr);

                    for (int v : near) {
                        if (v != -1) {
                            graph[u].add(v);
                        }
                    }
                }
            }

            visited = new boolean[size];
            int count = 0;

            for (int i = 0; i < size; i++) {
                int row = i / M;
                int col = i % M;

                if (arr[row][col] == 1 && !visited[i]) {
                    dfs(i);
                    count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static int[] checkNearNumber(int x, int y, int[][] arr) {
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

