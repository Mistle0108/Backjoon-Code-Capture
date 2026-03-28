import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());

            int[] input = new int[M];
            int idx = 0;

            while (idx < M) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    input[idx++] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            int[] result = new int[(M + 1) / 2];
            int count = 0;

            for (int i = 0; i < M; i++) {
                int num = input[i];

                if (left.isEmpty() || num <= left.peek()) {
                    left.add(num);
                } else {
                    right.add(num);
                }

                if (left.size() > right.size() + 1) {
                    right.add(left.poll());
                } else if (right.size() > left.size()) {
                    left.add(right.poll());
                }

                if (i % 2 == 0) {
                    result[count++] = left.peek();
                }
            }

            bw.write(count + "\n");
            for (int i = 0; i < count; i++) {
                bw.write(result[i] + " ");
                if ((i + 1) % 10 == 0) bw.write("\n");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}