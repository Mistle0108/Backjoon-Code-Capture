import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long n = Long.parseLong(br.readLine());
        
                
        bw.write(String.valueOf(n*(n-1)*(n-2)/6));
        bw.write("\n");
        bw.write(String.valueOf(3));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}