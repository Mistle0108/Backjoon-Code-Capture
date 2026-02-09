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
        
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        
        bw.write(GetLcm(a,b) + " ");
        
        
        bw.flush();
        
        br.close();
        bw.close();
    }
	
	static long GetLcm(long a, long b) {
		
		long n = a;
		long m = b;
		
		if(a == b) return a;
		
		int i = 1;
		int j = 1;
		
		while(true) {

			if(n > m) {
				m = b * j++;
			} else if(n < m){
				n = a * i++;
			} else {
				return n;
			}
			
		}
	}
	
}