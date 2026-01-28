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

        int[] x = new int[input];
        int[] y = new int[input];
        
        for(int i=0; i <input; i++) {
        	String [] number = br.readLine().split(" ");
        	x[i] = Integer.parseInt(number[0]);
        	y[i] = Integer.parseInt(number[1]);
        }

        int maxX = x[0];
        int maxY = y[0];
        int minX = x[0];
        int minY = y[0];
        	
    	for(int j=1; j < input; j++) {
    		if(x[j] > maxX) {
    			maxX = x[j]; 
    		}
    		
    		if(x[j] < minX) {
    			minX = x[j];
    		}
    		
    		if(y[j] > maxY) {
    			maxY = y[j]; 
    		}
    		
    		if(y[j] < minY) {
    			minY = y[j]; 
    		}        		
    	}
        
        bw.write(String.valueOf((maxX-minX)*(maxY-minY)));
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}