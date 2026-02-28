
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
	
		bw.write(w(input) + "");
	
        bw.flush();
        bw.close();
        br.close();
	}
    static int w(int n) {

    	if (n == 1) return 1;
        if (n == 2) return 2;
    	
    	int[] f = new int[n+1];
    	
    	f[1] = 1;
    	f[2] = 2;
    	
    	for (int i = 3; i <= n; i++) {
			f[i] = (f[i-1] + f[i-2]) % 15746;
		}
    	
		return f[n];
    }
    
}