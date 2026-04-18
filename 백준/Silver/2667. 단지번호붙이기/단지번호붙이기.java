import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int size = N * N;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        graph = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (arr[i][j] == 0) continue;

                int u = i * N + j;
                int[] near = checkNearNumber(i, j);

                for (int v : near) {
                    if (v != -1) {
                        graph[u].add(v);
                    }
                }
            }
        }

        visited = new boolean[size];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int x = i / N;
            int y = i % N;

            if (arr[x][y] == 1 && !visited[i]) {
                int count = dfs(i);
                result.add(count);
            }
        }

        Collections.sort(result);

        bw.write(result.size() + "\n");
        for (int num : result) {
            bw.write(num + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }

        return count;
    }

    static int[] checkNearNumber(int x, int y) {
        int[] temp = new int[4];
        int idx = 0;

        if (x + 1 < N && arr[x + 1][y] == 1) {
            temp[idx++] = (x + 1) * N + y;
        } else temp[idx++] = -1;

        if (x - 1 >= 0 && arr[x - 1][y] == 1) {
            temp[idx++] = (x - 1) * N + y;
        } else temp[idx++] = -1;

        if (y + 1 < N && arr[x][y + 1] == 1) {
            temp[idx++] = x * N + (y + 1);
        } else temp[idx++] = -1;

        if (y - 1 >= 0 && arr[x][y - 1] == 1) {
            temp[idx++] = x * N + (y - 1);
        } else temp[idx++] = -1;

        return temp;
    }
}

