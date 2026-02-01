import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());

        int i = 0;
        
        while(input != i) {
        	
        	i++;
        	int sum = i;       	
        	String num = String.valueOf(i);
        	
        	for(int j=0; j < num.length(); j++) {
        		sum += (num.charAt(j) - '0');
        	}
       	
        	if(input == sum) {
        		bw.write(String.valueOf(i));
        		break;
        	}
        	if(input == i) {
        		bw.write(String.valueOf(0));
        		break;
        	}
        }     
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}