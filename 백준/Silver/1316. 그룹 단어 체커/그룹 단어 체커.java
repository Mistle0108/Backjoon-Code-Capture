
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
		
		int input = Integer.parseInt(br.readLine());
		
		boolean [] checkChar = new boolean[26];
		
		
		int count = 0;
		
		boolean isGroupWord;
		
		for(int i=0; i<input; i++) {
			isGroupWord = true;
			
			String a = br.readLine();
			
			
			checkChar[((char)a.charAt(0) - 97)] = true;
			
			for(int k=0; k<a.length()-1; k++) {
				
				if(a.charAt(k) != a.charAt(k+1)) {
					if(checkChar[((char)a.charAt(k+1) - 97)] == true) {
						isGroupWord = false; 
						break;
					}else {
						checkChar[((char)a.charAt(k+1) - 97)] = true;						
					}
				}
			}
			Arrays.fill(checkChar, false);
			
			if(isGroupWord) count++;
			
			
		}
		
		
		bw.write(String.valueOf(count));
		
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}