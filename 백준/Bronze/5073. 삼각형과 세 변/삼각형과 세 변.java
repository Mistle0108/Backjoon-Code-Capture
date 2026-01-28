import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] tri = new int[3];
        
        
        int max = 0;
        int maxIdx = 0;
        
        int min = 0;
        int minIdx = 0;
        
        while(true) {
        	String[] input = br.readLine().split(" ");
        	
	        for(int i=0; i <3; i++) {
	        	tri[i] = Integer.parseInt(input[i]); 
	        	
	        	if(i == 0){ 
	        		max = tri[0];
	        		min = tri[0];
	        	}
	        	
	        	if(tri[i] > max) {
	        		max = tri[i];
	        		maxIdx = i;
	        	}
	        	
	        	if(tri[i] < min) {
	        		min = tri[i];
	        		minIdx = i;
	        	}
	        }
	        
	        if(tri[0] == 0 && tri[1] == 0 && tri[2] == 0) break;

	        if(tri[0] + tri[1] + tri[2] <= max*2) {
	        	bw.write("Invalid\n");
	        }else {
		        if(tri[0]+tri[1]+tri[2] == tri[0]*3) {
		        	bw.write("Equilateral\n");
		        } else if(tri[0] == tri[1] || tri[1] == tri[2] || tri[0] == tri[2] ){
		        	bw.write("Isosceles\n");
		        } else {
		        	bw.write("Scalene\n");
		        }
	        }
	        
        }
        
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}