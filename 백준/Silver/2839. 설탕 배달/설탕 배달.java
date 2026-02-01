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

        int min = -1;
        
        
        for (int i = input/5; i >= 0; i--) {
        	int remainder = input - i*5;
        	
        	if(remainder%3 == 0) {
        		min = i+ remainder/3;
        		break;
        	}
        	
		}
        bw.write(String.valueOf(min));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}