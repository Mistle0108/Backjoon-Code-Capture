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
        
        int input = Integer.parseInt(br.readLine());
        
        int[] nArr = new int[input];
        int[] mArr = new int[input-1];
        
        
        for (int i = 0; i < input; i++) {
        	nArr[i] = Integer.parseInt(br.readLine()); 
		}
        
        for(int i = 0; i < input-1; i++) {
        	mArr[i] = nArr[i+1] - nArr[i]; 
        }
        
        int gcd = mArr[0];
        
        for (int i = 1; i < mArr.length; i++) {
            gcd = GetGcd(gcd, mArr[i]);
        }
        
        int total = (nArr[input - 1] - nArr[0]) / gcd + 1;
        int result = total - input;

        bw.write(result + "");
                
        bw.flush();
        
        br.close();
        bw.close();
	}
	
	static int GetGcd(int a, int b) {
	    while (b != 0) {
	        int temp = a % b;
	        a = b;
	        b = temp;
	    }
	    return a;
	}
}