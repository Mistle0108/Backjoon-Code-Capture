
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String[] input = br.readLine().split(" ");
        
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);
        
        if(w-x > x) {
        	if(h-y > x) {
        		if(y > x) {
        			bw.write(String.valueOf(x));
        		}else {
        			bw.write(String.valueOf(y));
        		}
        	}else {
        		if(y > h-y) {
        			bw.write(String.valueOf(h-y));
        		}else {
        			bw.write(String.valueOf(y));
        		}
        	}
        }else {
        	if(h-y > w-x) {
        		if(y > w-x) {
        			bw.write(String.valueOf(w-x));
        		}else {
        			bw.write(String.valueOf(y));
        		}
        	}else {
        		if(y > h-y) {
        			bw.write(String.valueOf(h-y));
        		}else {
        			bw.write(String.valueOf(y));
        		}
        	}
        }
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}