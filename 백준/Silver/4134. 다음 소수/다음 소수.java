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
        
        long input = Long.parseLong(br.readLine());
        
        for (int i = 0; i < input; i++) {
        	long temp = Long.parseLong(br.readLine());
        	
        	int k = 0;
        	while(!isPrime(temp)) {
        		k++;
        		if(isPrime(temp+k)) break;
        	}
        	        	
        	bw.write(temp+k +"\n");
        	
		}
             
        bw.write("");
                
        bw.flush();
        
        br.close();
        bw.close();
	}
	
	static boolean isPrime(long n) {
	    if (n < 2) return false;
	    
	    for (long i = 2; i * i <= n; i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}	
}

