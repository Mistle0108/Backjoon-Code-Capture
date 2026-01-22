
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
		
		
		//9
		for(int i = 0; i < input * 2 - 1 ; i++) {
		
			if(i <= input-1) {
				for(int k = 0; k < input-i-1; k++) {
					bw.write(" ");				
				}
				for(int j = 0; j < i*2+1; j++) {
					bw.write("*");				
				}
				
			}else {
				for(int k = 0; k < i-input + 1; k++) {
					bw.write(" ");				
				}
				
				for(int j = 0 ; j < (input*2-i-1)*2-1; j++) {
					bw.write("*");
				}
				
			}
			bw.newLine();
		}
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}