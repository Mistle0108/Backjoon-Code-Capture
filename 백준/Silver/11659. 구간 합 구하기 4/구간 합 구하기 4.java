import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] input = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);
    	
    	String[] nNumbers = br.readLine().split(" ");
    	
    	int[] dp = new int[n+1];
    	
    	for (int i = 1; i <= n; i++) {
			dp[i] = dp[i-1] + Integer.parseInt(nNumbers[i-1]); 
		}
    	
    	for (int i = 0; i < m; i++) {
    		String[] temp = br.readLine().split(" ");
    		bw.write(dp[Integer.parseInt(temp[1])] - dp[Integer.parseInt(temp[0]) - 1] + "\n");
		}
    	
    	    	
        bw.flush();
        bw.close();
        br.close();
    }
}