
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

    	int[] arr = new int[input*(input+1)/2];
    	int[] dp = new int[input*(input+1)/2];
    	
    	int k = 0;
    	for (int i = 0; i < input; i++) {
    		String[] temp = br.readLine().split(" ");
    		for (int j = 0; j < temp.length; j++) {
				arr[k++] = Integer.parseInt(temp[j]);
			}
		}

    	dp[0] = arr[0];
    	
    	for (int i = 1; i < input; i++) { //input = 5일 때 5줄만큼 반복
    		
    		int prevStart = i*(i-1)/2;
    		int nextStart = i*(i+1)/2;
    		
    		for (int j = 0; j <= i; j++) { // 2번째 줄은 2번, 3번째 줄은 3번
    			if(j == 0) { // 첫 값 
    				dp[nextStart+j] 
    					= arr[nextStart+j] + dp[prevStart+j];
    			} else if (j == i) { // 끝 값 
    				dp[nextStart+j] 
    					= arr[nextStart+j] + dp[prevStart+j-1];
    			} else { // 중간 값
    				dp[nextStart+j]  
    					= arr[nextStart+j] + Math.max(dp[prevStart+j-1], dp[prevStart+j]);
    			}
			}    		 
		}
    	
        int max = 0;

        for (int i = (input-1)*input/2; i < (input+1)*input/2; i++) {
            max = Math.max(max, dp[i]);
        }
    	
    	bw.write(max +"");
    	
        bw.flush();
        bw.close();
        br.close();
	}

}