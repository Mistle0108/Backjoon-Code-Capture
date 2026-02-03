import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] nArray = new int[5];
        
        int sum = 0;
        
        for (int i = 0; i < 5; i++) {
        	nArray[i] = Integer.parseInt(br.readLine());
        	sum += nArray[i];
		}
        
        for (int j = 0; j < nArray.length; j++) {
	        for(int i = 0; i<4; i++) {
	        	if(nArray[i] > nArray[i+1]) {
	        		int temp = nArray[i];
	        		nArray[i] = nArray[i+1];
	        		nArray[i+1] = temp;
	        	}
	        }
        }
        
        bw.write(sum/5 +"\n" + nArray[2]);
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}