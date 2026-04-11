import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static int n, m, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

         while (T > 0) {
        	T--;
 
        	/* n: 교차로
        	 * m: 간선
        	 * t: 목적지 후보
        	 * */
            String[] input1 = br.readLine().split(" ");
            n = Integer.parseInt(input1[0]);
            m = Integer.parseInt(input1[1]);
            t = Integer.parseInt(input1[2]);

            /* s: 예술가 출발지
        	 * g, h: 필수 경유지 
        	 * */
            String[] input2 = br.readLine().split(" ");
            int s = Integer.parseInt(input2[0]);
            int g = Integer.parseInt(input2[1]);
            int h = Integer.parseInt(input2[2]);

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int ghDistance = 0;

            // 양방향 그래프 구성
            // a: 시작 노드
            // b: 도착 노드
            // d: 사이의 가중치
            for (int i = 0; i < m; i++) {
            	String[] input3 = br.readLine().split(" ");

                int a = Integer.parseInt(input3[0]);
                int b = Integer.parseInt(input3[1]);
                int d = Integer.parseInt(input3[2]);

                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));

                // g와 h 교차로 사이에 있는 도로를 지나감
                if ((a == g && b == h) || (a == h && b == g)) {
                	ghDistance = d;
                }
            }

            int[] arr = new int[t];
            
            for (int i = 0; i < t; i++) {
            	arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int[] distS = dijkstra(s);
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);

            for (int i : arr) {
                int path1 = distS[g] + ghDistance + distH[i];
                int path2 = distS[h] + ghDistance + distG[i];

                if (distS[i] == path1 || distS[i] == path2) {
                    bw.write(i + " ");
                }
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.distance > dist[current.index]) continue;

            for (Node next : graph[current.index]) {
                if (dist[next.index] > current.distance + next.distance) {
                    dist[next.index] = current.distance + next.distance;
                    pq.add(new Node(next.index, current.distance + next.distance));
                }
            }
        }

        return dist;
    }
    
}

