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
        
        int input = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < input; i++) {
        	String[] temp = br.readLine().split(" ");
        	int a = Integer.parseInt(temp[0]);
        	int b = Integer.parseInt(temp[1]);
        	
        	bw.write(GetLcm(a,b) + "\n");
		}
        
        bw.flush();
        
        br.close();
        bw.close();
    }
	
	static int GetLcm(int a, int b) {
		
		int n = a;
		int m = b;
		
		if(a == b) return a;
		
		int i = 1;
		int j = 1;
		
		while(true) {

			if(n > m) {
				m = b * j++;
			} else if(n < m){
				n = a * i++;
			} else {
				return n;
			}
			
		}
	}
	
}

