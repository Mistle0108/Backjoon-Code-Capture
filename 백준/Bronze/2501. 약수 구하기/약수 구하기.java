import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        
    	String[] input = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(input[0]);
    	int k = Integer.parseInt(input[1]);

    	int count = 0;
    	
    	for(int i = 1; i <= n; i++) {
    		if(n % i == 0) count++;
    		if(count == k) {
    			bw.write(String.valueOf(i));
    			break;
    		}
    	}
    	
    	if(k > count) bw.write(String.valueOf(0));
    	
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}