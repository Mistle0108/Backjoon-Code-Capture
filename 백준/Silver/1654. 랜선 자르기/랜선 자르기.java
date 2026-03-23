import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        
        int[] arr = new int[k];
        
        long max = 0;
        
        for (int i = 0; i < k; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	max += arr[i];
		}
        
        long left = 1;
        long right = max/n;
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long count = 0;
            
            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }
            
            if (count >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

}