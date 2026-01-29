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
        
        int sum = 0; 
     
        for(int i = 0; i < input; i++) {
        	sum += i;
        }
        
        
        
        bw.write(String.valueOf(input) +"\n");
        bw.write(String.valueOf(1));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}