import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        
        
        for (int i = 0; i < input; i++) {
            String[] temp = br.readLine().split(" ");
            
            int s = Integer.parseInt(temp[0]);
            int d = Integer.parseInt(temp[1]);
            
            BigInteger reuslt = factorial(d).divide(factorial(s)).divide(factorial(d-s));
            
            bw.write(reuslt +"\n");
		}
        
        bw.flush();
        
        br.close();
        bw.close();
	}
	
	static BigInteger factorial(int n) {
	    BigInteger result = BigInteger.ONE;

	    for (int i = 1; i <= n; i++) {
	        result = result.multiply(BigInteger.valueOf(i));
	    }

	    return result;
	}
}