
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String[] n =br.readLine().split(" ");

        int a = Integer.parseInt(n[0]);
        int b = Integer.parseInt(n[1]);
        int v = Integer.parseInt(n[2]);
        
        int result = (v - a) % (a - b) == 0 ? (v - a) / (a - b) : (v - a) / (a - b) + 1;
        
        bw.write(String.valueOf(result + 1));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}