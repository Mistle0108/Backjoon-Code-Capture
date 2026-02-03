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
        
        String[] input = br.readLine().split(" ");
        String[] score = br.readLine().split(" ");
        
        int[] nArray = new int[Integer.parseInt(input[0])];
        
        
        for (int i = 0; i < nArray.length; i++) {
        	nArray[i] = Integer.parseInt(score[i]);
		}
        
        for (int j = 0; j < nArray.length; j++) {
	        for(int i = 0; i<nArray.length-1; i++) {
	        	if(nArray[i] < nArray[i+1]) {
	        		int temp = nArray[i];
	        		nArray[i] = nArray[i+1];
	        		nArray[i+1] = temp;
	        	}
	        }
        }
        
        bw.write(nArray[Integer.parseInt(input[1]) - 1] +"");
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}