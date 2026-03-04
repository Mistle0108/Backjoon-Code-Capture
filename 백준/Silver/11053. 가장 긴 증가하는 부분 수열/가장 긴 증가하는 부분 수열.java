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

    	String[] temp = br.readLine().split(" ");
    	
    	int[] arr = new int[n+1];
    	int[] dp = new int[n+1];

    	for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			dp[i] = 1;
		}
    	
    	int max = 1;
    	
    	for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
    	
    	bw.write(max +"");
    	
        bw.flush();
        bw.close();
        br.close();
	}
}