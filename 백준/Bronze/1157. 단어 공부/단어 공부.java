
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine().toUpperCase();

		int[] charSlot = new int[26];
		
		for(int i=0; i<input.length(); i++) {
			charSlot[input.charAt(i)-65] += 1;
		}
		
		int max = charSlot[0];
		int maxIdx = 0;
		int peak = 0;
		char maxChar = 'A';
		
		
		for(int i=1; i<charSlot.length; i++) {
			
			if(charSlot[i] > max) {
				max = charSlot[i];
				maxIdx = i;
			}else if(charSlot[i] == max){
				peak = max;
			}
		}
		
		if(peak == max) 
			bw.write("?");
		else 
			bw.write((char)(maxIdx + 65));
		
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}