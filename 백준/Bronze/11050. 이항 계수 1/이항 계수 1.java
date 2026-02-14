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
        
        
        
        int n = 1;
    	for (int i = 0; i < Integer.parseInt(input[0]); i++) {
        	n *= (i+1);
		}
    	
    	int k = 1;
    	for (int i = 0; i < Integer.parseInt(input[1]); i++) {
        	k *= (i+1);
		}
    	
    	int t = 1;
    	for (int i = 0; i < Integer.parseInt(input[0]) - Integer.parseInt(input[1]); i++) {
        	t *= (i+1);
		}
    	
    	
    	bw.write(n/(k*t) +"");
    
        
        bw.flush();
        
        br.close();
        bw.close();
	}
}