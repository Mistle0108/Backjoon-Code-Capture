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
        
        int n = Integer.parseInt(br.readLine());
        
        int[] nArray = new int[n];
        
        for (int i = 0; i < n; i++) {
        	nArray[i] = Integer.parseInt(br.readLine());
		}
        
        for (int j = 0; j < nArray.length; j++) {
	        for(int i = 0; i<n-1; i++) {
	        	if(nArray[i] > nArray[i+1]) {
	        		int temp = nArray[i];
	        		nArray[i] = nArray[i+1];
	        		nArray[i+1] = temp;
	        	}
	        }
        }
        
        for (int i = 0; i < n; i++) {
        	bw.write(nArray[i] + "\n");
        }
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}