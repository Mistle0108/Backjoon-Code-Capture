import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        for(int i = n; i <= m; i++ ) {
        	if(isPrime(i)) bw.write(i +"\n");
        }
        
        bw.flush();
        
        br.close();
        bw.close();
	}
	
	static boolean isPrime(int n) {
	    if (n < 2) return false;
	    
	    for (int i = 2; i * i <= n; i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}	
	
}