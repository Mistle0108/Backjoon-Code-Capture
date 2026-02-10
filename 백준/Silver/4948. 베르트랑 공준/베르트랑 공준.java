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
        
        while(true) {
        	int input = Integer.parseInt(br.readLine());
        
        	if(input == 0) break;
        	
        	int count = 0;
        	
        	for(int i = input+1; i <= input*2; i++) {
        		
        		if(isPrime(i)) count++;
        	}
        	
        	bw.write(count +"\n");
        	
        	count = 0;
        	
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