import java.io.*;
import java.util.*;

class Main {
	
	static class Jewel {
        int weight;
        int value;

        Jewel(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
       
        Jewel[] jewels = new Jewel[N];
        
        for (int i = 0; i < N; i++) {
        	String[] temp = br.readLine().split(" ");
        	jewels[i] = new Jewel(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		}
        
        Arrays.sort(jewels, (a, b) -> a.weight - b.weight);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        
        long result = 0;
        int idx = 0;

        for (int i = 0; i < bags.length; i++) {
        	
        	while (idx < N && jewels[idx].weight <= bags[i]) {
                pq.add(jewels[idx].value);
                idx++;
            }
    
        	if (!pq.isEmpty()) {
                result += pq.poll();
            }
		}
        
        bw.write(result + "");
        
        bw.flush();
        br.close();
        bw.close();
    }
}