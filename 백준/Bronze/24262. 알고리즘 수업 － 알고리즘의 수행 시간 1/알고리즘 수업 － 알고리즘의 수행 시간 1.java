
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
        
        bw.write(String.valueOf(1) +"\n");
        bw.write(String.valueOf(0));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}