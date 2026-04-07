import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int Case = Integer.parseInt(br.readLine());

        for (int c = 0; c < Case; c++) {
            int n = Integer.parseInt(br.readLine());

            int[] rank = new int[n];
            String[] temp = br.readLine().split(" ");

            for (int i = 0; i < temp.length; i++) {
                rank[i] = Integer.parseInt(temp[i]);
            }

            boolean[][] graph = new boolean[n + 1][n + 1];
            int[] indegree = new int[n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    graph[rank[i]][rank[j]] = true;
                    indegree[rank[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                String[] temp2 = br.readLine().split(" ");

                int a = Integer.parseInt(temp2[0]);
                int b = Integer.parseInt(temp2[1]);

                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    graph[b][a] = false;
                    graph[a][b] = true;
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                	queue.add(i);
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            boolean contra = false;
            boolean notConfirmed = false;

            for (int i = 0; i < n; i++) {
                if (queue.isEmpty()) {
                	contra = true;
                    break;
                }
                if (queue.size() > 1) {
                	notConfirmed = true;
                    break;
                }

                int curr = queue.poll();
                result.add(curr);

                for (int next = 1; next <= n; next++) {
                    if (graph[curr][next]) {
                        indegree[next]--;

                        if (indegree[next] == 0) {
                            queue.add(next);
                        }
                    }
                }
            }

            if (contra) {
                bw.write("IMPOSSIBLE\n");
            } else if (notConfirmed) {
            	bw.write("?\n");
            } else {
                for (int team : result) {
                	bw.write(team + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}