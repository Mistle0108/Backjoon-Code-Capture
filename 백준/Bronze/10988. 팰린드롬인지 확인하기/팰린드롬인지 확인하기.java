import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		boolean isPalindrome = true;

		for(int i = 0; i < input.length()/2; i++) {
			
			if(input.charAt(i) != input.charAt(input.length()-i-1)) {
				isPalindrome = false;
				break;
			}
		}
		
		if(isPalindrome) {
			bw.write("1");
		}else {
			bw.write("0");
		}
	
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}