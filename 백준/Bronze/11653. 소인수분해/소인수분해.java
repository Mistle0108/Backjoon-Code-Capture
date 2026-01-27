
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
        
        int current = input;
        int i = 1;
        
        while(true) {
        	if(current == 1) break;
        	
        	i++;
        	
        	if(current % i == 0) {
    			current /= i;
    			bw.write(i + "\n");
    			i = 1;
        	}
        }
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}
