import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] input = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);

    	String[] temp = br.readLine().split(" ");
    	
    	long[] arr = new long[temp.length + 1];
    	
    	for (int i = 1; i <= temp.length; i++) {
			arr[i] = Integer.parseInt(temp[i-1]);
		}
    	
    	long[] dp = new long[n+1];
    	
    	long count = 0;
    	
    	dp[0] = 0;
    	
    	long[] modArr = new long[m];
    	
    	for (int i = 1; i <= n; i++) {
    		dp[i] = dp[i-1] + arr[i];
    		
    		if(dp[i]%m == 0) {
    			count++;
    		}
    		
    		modArr[(int) (dp[i]%m)]++;
		}
    	
    	for (int i = 0; i < m; i++) {
            if (modArr[i] > 1) {
            	count += (modArr[i] * (modArr[i] - 1) / 2);
            }
        }
    	
    	bw.write(count + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
