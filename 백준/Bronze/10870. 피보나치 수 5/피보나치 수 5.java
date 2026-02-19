import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        
        bw.write(Fibonacci(input)+"");
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
    
    public static long Fibonacci(int n) {
    	
    	if(n == 0) return 0;
    	if(n == 1) return 1;
    	
    	return Fibonacci(n-1) + Fibonacci(n-2);
    	
    }
    
    
}