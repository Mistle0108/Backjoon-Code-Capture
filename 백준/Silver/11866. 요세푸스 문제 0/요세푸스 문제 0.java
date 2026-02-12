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

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
    	
        int[] arr = new int[n];
        
        bw.write("<");
        
        
        for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
        
        int count = n;
        int current = -1;
        while(count != 0) {
        	
        	
        	for (int i = 0; i < k; i++) {
        		current++;
        		if(arr[current%n] == 0) {
        			i--;
        		}
        		
			}
        	count--;
        	
        	if(count == 0) bw.write(arr[current%n] + ""); 
        	else bw.write(arr[current%n] + ", ");
        	
        	arr[current%n] = 0;
        }
        
        bw.write(">");
        
        bw.flush();
        
        br.close();
        bw.close();
	}
	
}