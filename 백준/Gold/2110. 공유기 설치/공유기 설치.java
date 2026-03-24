import java.io.*;
import java.util.*;

// 도현이는 다주택자..

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        
        int[] arr= new int[N];
        
        for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        
        Arrays.sort(arr);
        
        int left = 1;
	    int right = arr[N-1] - arr[0];
        int maxDistance = 0;
	    
        while (left <= right) {

        	int mid = (left + right)/2;
        	
        	int count = 1;
        	int last = arr[0];
        	
        	for (int i = 1; i < N; i++) {
                if (arr[i] - last >= mid) {
                    count++;
                    last = arr[i];
                }
            }

            if (count >= C) {
            	maxDistance = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        	
        }
        
        bw.write(maxDistance + "");
        
        bw.flush();
        br.close();
        bw.close();
    }

}