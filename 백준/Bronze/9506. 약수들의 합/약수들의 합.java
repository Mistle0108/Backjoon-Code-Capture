import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
    	while(true) {
    		int input = Integer.parseInt(br.readLine());
    		if(input == -1) break;
    		
    		int total = 0;
    		
    		for(int i = 1; i < input; i++) {
    			if(input % i == 0) total += i;
    		}
    		
    		if(total == input) {
    			bw.write(input + " = 1");
    			for(int i = 2; i < input; i++) {
        			if(input % i == 0) bw.write(" + " + i); 
        		}
    			bw.write("\n");
    		}else {
    			bw.write(input + " is NOT perfect.\n");
    		}
    	}
    	    	
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}