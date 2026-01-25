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

        int count = 0;
        
        int temp = n;
        
        while(true) {
        	temp -= count * 6;

        	count++;
        	
        	if(temp <= 1)
        		break;
        }
        
        bw.write(String.valueOf(count));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}