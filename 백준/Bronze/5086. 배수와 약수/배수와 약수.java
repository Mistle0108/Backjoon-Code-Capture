import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        
        while(true) {
        	String[] input = br.readLine().split(" ");
        	
        	int a = Integer.parseInt(input[0]);
        	int b = Integer.parseInt(input[1]);
        	
        	if(a == b) break;
        	
        	if(a > b) {  
        		if(a % b == 0) bw.write("multiple" + "\n");
        		else bw.write("neither"+ "\n");
        	} else if (a < b) {  
        		if(b % a == 0) bw.write("factor"+ "\n");
        		else bw.write("neither"+ "\n"); 
        	}
        	
        }
        
        
        
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}