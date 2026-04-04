import java.io.*;
import java.util.*;

// 시작 정점에서 N-1, N+1, N*2 이동 가능
class Main {

    static int N, M;
    static boolean[] visited = new boolean[100001];
    static int[] dist = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        bfs(N);

        bw.write(dist[M]+"");
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int next = queue.poll();

            if (next == M) return;

            int[] temp = {next + 1, next - 1, next * 2};

            for (int i : temp) {
                if (i >= 0 && i <= 100000 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[next] + 1;
                    queue.add(i);
                }
            }
        }
    }
}

