import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int t = Integer.parseInt(br.readLine());

        
        
        for(int i = 0; i < t; i++) {
        	int c = Integer.parseInt(br.readLine());
        	
        	int temp = 0;
        	int Quarter = c / 25;
        	
        	temp = c % 25;
            int Dime = temp / 10;
            
            temp = temp % 10;
            int Nickel = temp / 5;

            int Penny = temp % 5;
        	
        	bw.write(Quarter + " " + Dime + " " + Nickel + " " + Penny);
        	
        	if(i != t-1) bw.write("\n");
        }
	    
        bw.flush();                   
        
        br.close();
        bw.close();
	}
}