
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

        String[] numbers = br.readLine().split(" ");
    	
        int totalCount = 0;
        for (int i = 0; i < n; i++) {

        	int count = 0;
        	for(int k = 1; k <= Integer.parseInt(numbers[i]); k++) {
        		if(Integer.parseInt(numbers[i]) % k == 0) count++;  
        	}
        	if(count == 2) totalCount++; 
        	count = 0;
		}
    		
    	bw.write(String.valueOf(totalCount));
    	    	
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}