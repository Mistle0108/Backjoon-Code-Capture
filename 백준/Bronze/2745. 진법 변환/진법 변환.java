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
        String n = input[0];
        int b = Integer.parseInt(input[1]);
        
        int total = 0;
        int placeValue = 1;
        int digit = 0;
        
        for(int i=0; i < n.length(); i++) {
        	
        	for(int k = 0; k < i; k++) {
        		placeValue *= b;
        	}
        	
        	digit = Character.getNumericValue(n.charAt(n.length() - 1 - i));
        	
        	total += placeValue * digit;
        	placeValue = 1;
        }
        
        bw.write(String.valueOf(total));
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}