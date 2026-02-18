import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        
        String [] temp = br.readLine().split(" ");
        
        int [] factor = new int[input];
        
        for (int i = 0; i < input; i++) {
        	factor[i] = Integer.parseInt(temp[i]);
		}

        Arrays.sort(factor);
        
        if(input % 2 == 0) {
        	bw.write(factor[0]*factor[input-1] + "");
        }else {
        	int mid = input / 2;
        	bw.write(factor[mid] * factor[mid] + "");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}