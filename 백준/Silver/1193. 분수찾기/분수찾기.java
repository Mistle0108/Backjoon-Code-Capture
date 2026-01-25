
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int n = Integer.parseInt(br.readLine());

        int molecule = 0;
        int denominator = 0;

        int count = 1;
        
        int temp = n;
        
        while(true) {
        	temp -= count;
        	
        	if(temp <= 0) break;
        	
        	count++;
        }
        
        int groupFirstPos = 1;
        for(int i=1; i < count; i++) {
        	groupFirstPos += i;
        }
        
        int order = n - groupFirstPos;
        
        if(count % 2 == 0) {
        	denominator = count - order; 
        	molecule = count + 1 - denominator; 
        } else {
        	molecule = count - order;
        	denominator = count + 1 - molecule;
        }

        
        bw.write(molecule + "/" + denominator);
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}