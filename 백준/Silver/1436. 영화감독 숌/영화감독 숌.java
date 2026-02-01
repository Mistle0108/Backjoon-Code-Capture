import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
                
        int count = 0;
        int num = 665;
        
        while(true) {
        	num++;
        	
        	if(String.valueOf(num).indexOf("666") != -1) {
        		count++;
        	}
        	
        	if(count == input) break;
        }
        
        bw.write(String.valueOf(num));
        
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}