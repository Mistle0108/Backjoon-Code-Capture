import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

class Main {
	
	static int recursionCount = 0;
	static int dpCount = 0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	int input = Integer.parseInt(br.readLine());

    	recursion(input);
    	dp(input);
    	bw.write(recursionCount + " " + dpCount);
    	
        bw.flush();
        bw.close();
        br.close();
	}
	
    static int recursion(int n) {
    	

    	if(n == 1 || n == 2) {
    		recursionCount++;
    		return 1;
    	}
    	
    	return recursion(n-1) + recursion(n-2);
    }
    
    static int dp(int n) {
    	int [] f = new int[n+1];
    	
    	f[1] = 1;
    	f[2] = 1;
    	
    	for (int i = 3; i <= n; i++) {
    		dpCount++;
			f[i] = f[i-1] + f[i-2];
		}
    	
    	return f[n];
    }
    
}