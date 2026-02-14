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
        
        int k = 1;
        if(input == 0) {
        	bw.write(k+"");
        }
        else {
        	for (int i = 0; i < input; i++) {
            	k *= (i+1);
    		}
        	bw.write(k +"");
        }
        
        
        bw.flush();
        
        br.close();
        bw.close();
	}
}