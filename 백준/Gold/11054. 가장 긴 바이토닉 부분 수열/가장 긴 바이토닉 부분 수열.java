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
    	
    	int[] arr = new int[n];
    	int[] dp1 = new int[n];
    	int[] dp2 = new int[n];

    	for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);			
			dp1[i] = 1;
			dp2[i] = 1;
		}
    	
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }
    	
    	bw.write(max + "");
    	
        bw.flush();
        bw.close();
        br.close();
	}
}