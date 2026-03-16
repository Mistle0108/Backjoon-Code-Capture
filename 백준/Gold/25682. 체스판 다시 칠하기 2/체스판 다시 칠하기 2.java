import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] input = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);
    	int k = Integer.parseInt(input[2]);
    	
    	
    	char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
    	
    	int[][] dp = new int[n+1][m+1];
    	
    	char rightChar;
    	
    	for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				
				if((i+j)%2 == 0) rightChar = 'B';
				else rightChar = 'W';
				
				int wrongCount = (board[i-1][j-1] == rightChar) ? 0 : 1;
				
				dp[i][j] = wrongCount + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];  				
			}
		}
    	
    	int min = Integer.MAX_VALUE;
    	
    	for (int i = k; i <= n; i++) {
			for (int j = k; j <= m; j++) {
				int prefixSumB = dp[i][j] - dp[i-k][j] - dp[i][j-k] + dp[i-k][j-k];
				int prefixSumW = (k * k) - prefixSumB;
				
				min = Math.min(min, Math.min(prefixSumW, prefixSumB));
			}
		}
    	
    	bw.write(min+ "");

        bw.flush();
        bw.close();
        br.close();
    }
}