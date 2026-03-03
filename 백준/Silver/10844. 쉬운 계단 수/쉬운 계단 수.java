import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    	int n = Integer.parseInt(br.readLine());

    	long[][] dp = new long[n+1][10];
    
    	for (int i = 1; i <= 9; i++) {
    		dp[1][i] = 1;
		}
    	
    	for (int i = 2; i <= n; i++) {
    		dp[i][0] = dp[i-1][1] % 1000000000;
			dp[i][9] = dp[i-1][8] % 1000000000;
    		for (int j = 1; j < 9; j++) {
    			dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
    	}
    	
    	long sum = 0;
    	for (int i = 0; i < dp[n].length; i++) {
    		sum = (sum + dp[n][i]) % 1000000000;
		}
    	bw.write(sum+"");
    	
        bw.flush();
        bw.close();
        br.close();
	}
}