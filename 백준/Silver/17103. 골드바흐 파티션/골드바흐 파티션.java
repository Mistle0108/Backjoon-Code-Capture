import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        
        int[] nArr = new int[input];

        int max = 0;
        for (int i = 0; i < input; i++) {
        	nArr[i] = Integer.parseInt(br.readLine());
        	max = Math.max(max, nArr[i]);
        }
        
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = false; 
        prime[1] = false;
        
        for (int i = 2; i * i <= max; i++) {
        	if(prime[i]) {
        		for(int j = i * i; j <= max; j +=i) {
		        	prime[j] = false;
        		}
        	}
	    }
        
        for (int i = 0; i < input; i++) {

        	int n = nArr[i];
        	
        	int count = 0;
        	
        	for(int j = 2; j <= n/2; j++) {
        		if(prime[j] && prime[n-j]) {
        			count++;
        		}
        	}
        	bw.write(count + "\n");
		}
        
        bw.flush();
        
        br.close();
        bw.close();
	}
}