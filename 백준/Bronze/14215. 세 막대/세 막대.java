import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        String[] input = br.readLine().split(" ");
        
        int[] sticks = {Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])};
        
        Arrays.sort(sticks);
        
        if(sticks[0] + sticks[1] > sticks[2]) {
        	bw.write(String.valueOf(sticks[0] + sticks[1] + sticks[2]));
        }else {
        	bw.write(String.valueOf(sticks[0] + sticks[1] + sticks[0] + sticks[1] -1));
        }
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}