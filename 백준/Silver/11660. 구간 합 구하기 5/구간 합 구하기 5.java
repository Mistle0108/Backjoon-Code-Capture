import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] input = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);

    	int[][] dp = new int[n+1][n+1];
    	
    	for(int i = 1; i <= n; i++){
            String[] temp = br.readLine().split(" ");

            for(int j = 1; j <= n; j++){
                int num = Integer.parseInt(temp[j-1]);
                dp[i][j] = num + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                //dp[1][1] = 1 + 0 + 0 - 0
                //dp[1][2] = 2 + 0 + 1 - 0
            }
        }
    	
    	for(int i = 0; i < m; i++){

            String[] params = br.readLine().split(" ");

            int x1 = Integer.parseInt(params[0]);
            int y1 = Integer.parseInt(params[1]); 
            int x2 = Integer.parseInt(params[2]);
            int y2 = Integer.parseInt(params[3]);

            int result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];		
            bw.write(result + "\n");
        }
    	
    	
    	bw.write("");

        bw.flush();
        bw.close();
        br.close();
    }
}
