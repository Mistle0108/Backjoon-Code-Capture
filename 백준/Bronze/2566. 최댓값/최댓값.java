import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int max = 0;
        int maxIdxX = 0;
        int maxIdxY = 0;
        
        for (int i = 0; i < 9; i++) {
        	
        	String[] input = br.readLine().split(" ");
        	
        	for (int k = 0; k < 9; k++) {
        		
        		if(i == 0 && k == 0) {
            		max = Integer.parseInt(input[k]);
            		maxIdxX = 0;
            		maxIdxY = 0;
            	}
        	
        		if(Integer.parseInt(input[k]) > max) {
        			max = Integer.parseInt(input[k]);
        			maxIdxX = i;
            		maxIdxY = k;
        		}
    		}
		}
        
        bw.write(max + "\n" + (maxIdxX+1) + " "+ (maxIdxY+1));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}