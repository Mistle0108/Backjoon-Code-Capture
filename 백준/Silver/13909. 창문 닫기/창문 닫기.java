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
        
        int count = 0;
        for(int i = 2; i*i < input; i++) {
        	count++;
        }
        
        System.out.println(count+1);
        
        
        
        
        bw.flush();
        
        br.close();
        bw.close();
	}
}