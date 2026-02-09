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
        
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        int aNumerator = Integer.parseInt(a[0]);
        int aDenominator = Integer.parseInt(a[1]);
        
        int bNumerator = Integer.parseInt(b[0]);
        int bDenominator = Integer.parseInt(b[1]);

		int n = aDenominator;
		int m = bDenominator;
		
		int lcm = GetLcm(aDenominator, bDenominator);
		
        int rstNumerator = aNumerator*(lcm / aDenominator) + bNumerator*(lcm / bDenominator);
        int rstDenominator = lcm;
        
        int gcd = GetGcd(rstNumerator, rstDenominator);
        
        bw.write(rstNumerator /gcd + " " + rstDenominator / gcd);
                
        bw.flush();
        
        br.close();
        bw.close();
    }
	
	// least common multiple
    static int GetLcm(int a, int b) {
        return a * b / GetGcd(a, b);
    }

	// greatest common divisor
	static int GetGcd(int a, int b) {
	    while (b != 0) {
	        int temp = a % b;
	        a = b;
	        b = temp;
	    }
	    return a;
	}
	
}
