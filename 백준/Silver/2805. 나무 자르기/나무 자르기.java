import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int[] arr = new int[n];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
      
        String[] temp = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(temp[i]);
        	max = Math.max(max, arr[i]);
        	min = Math.min(min, arr[i]);
		}
        
        long left = 0;
        long right = max;
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long count = 0;
            
            for (int i = 0; i < n; i++) {
                long log = arr[i] - mid;
                if(log > 0) count +=log;
            }
            
            if (count >= m) {
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