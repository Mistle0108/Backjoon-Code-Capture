import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    	int input = Integer.parseInt(br.readLine());
	
    	int[][] arr = new int[input+1][3];
    	int[][] dp = new int[input+1][3];
    	
    	for (int i = 1; i <= input; i++) {
    		String[] temp =  br.readLine().split(" ");
    		
    		arr[i][0] = Integer.parseInt(temp[0]);
    		arr[i][1] = Integer.parseInt(temp[1]);
    		arr[i][2] = Integer.parseInt(temp[2]);
		}
    	
    	dp[1][0] = arr[1][0];
    	dp[1][1] = arr[1][1];
    	dp[1][2] = arr[1][2];
    	
    	for (int i = 2; i <= input; i++) {
    		dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
    		dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
    		dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
    	
    	bw.write(Math.min(dp[input][0], 
    		    Math.min(dp[input][1], dp[input][2])) + "");
    	
        bw.flush();
        bw.close();
        br.close();
	}

}