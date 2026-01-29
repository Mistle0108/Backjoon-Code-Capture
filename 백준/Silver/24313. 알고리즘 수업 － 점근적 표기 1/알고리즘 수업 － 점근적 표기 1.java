import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] a = br.readLine().split(" ");
        
        int a1 = Integer.parseInt(a[0]);
        int a0 = Integer.parseInt(a[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        
        int fn = a1*n0 + a0;
        int gn = n0;
                
        bw.write(a0 <= (c-a1)*gn && (c-a1) >= 0 ? String.valueOf(1) : String.valueOf(0));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}