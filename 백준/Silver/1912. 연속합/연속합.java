import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	int max = Integer.MIN_VALUE;
    	
    	int input = Integer.parseInt(br.readLine());
	
		int[] arr = new int[input];
		int[] dp = new int[input];
		
		String[] nums = br.readLine().split(" ");
		
		for (int i = 0; i < input; i++) {
			arr[i] = Integer.parseInt(nums[i]);			
		}
		
		dp[0] = arr[0];
		max = dp[0];
		for (int i = 1; i < arr.length; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			
			max = Math.max(max, dp[i]);
		}
		
		bw.write(max+"");
		
		
        bw.flush();
        bw.close();
        br.close();
	}

}