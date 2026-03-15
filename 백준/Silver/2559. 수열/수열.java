import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] input = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);

    	String[] temperature = br.readLine().split(" "); 
    	
    	int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temperature[i]);
        }
    	
    	
    	int[] dp = new int[n];
    	
    	for (int i = 0; i < m; i++) {
            dp[m - 1] += arr[i];
        }
    	
    	int max = dp[m - 1];
    	for (int i = m; i < n; i++) {
            dp[i] = dp[i - 1] - arr[i - m] + arr[i];
            max = Math.max(max, dp[i]);
        }

    	bw.write(max+"");
    	
    	    	
        bw.flush();
        bw.close();
        br.close();
    }
}
