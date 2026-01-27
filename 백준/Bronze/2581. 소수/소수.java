import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        
        int minimum = -1;
        int sum = 0;
        
        for (int i = start; i <= end; i++) {
        	
        	if(isPrime(i)) {
        		if(minimum == -1) minimum = i;
        		sum += i;
        	} 
		}
    		
        if(minimum == -1) {
        	bw.write(String.valueOf(minimum));
        }else {
        	bw.write(sum + "\n" + minimum);
        }
            	
        bw.flush();                   
        
        br.close();
        bw.close();
	}
	
	static boolean isPrime(int number) {
		int count = 0;
		
		for(int k = 1; k <= number; k++) {
    		if(number % k == 0) count++;  
    	}
    	if(count == 2) return true;
    	else return false;
    	
	}
	
}