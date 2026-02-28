import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int input = Integer.parseInt(br.readLine());
	
		for (int i = 0; i < input; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			bw.write(w(temp) + "\n");
		}
		
        bw.flush();
        bw.close();
        br.close();
	}
    static long w(int n) {

    	if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 1;
    	
        long[] f = new long[n+1];
    	
    	f[1] = 1;
    	f[2] = 1;
    	f[3] = 1;
    	
    	for (int i = 4; i <= n; i++) {
			f[i] = (f[i-2] + f[i-3]);
		}
    	
		return f[n];
    }
    
}