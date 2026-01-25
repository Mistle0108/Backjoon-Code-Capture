import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int quotient = n / b;
        int remainder = n % b;     

        char value = remainder >= 10 ? (char)(remainder + 55) :(char)(remainder + 48);

        String result = "";
        result = value + result;
        
	    while(quotient != 0) {
	    	remainder = quotient % b;
	    	quotient  = quotient / b;
	    	
	    	value = remainder >= 10 ? (char)(remainder + 55) :(char)(remainder + 48);
	    	result = value + result;
	    }
	    
	    bw.write(result);
	    
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}