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

		String[] HRToEn = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		int count = 0;
		
		for(int i=0; i<HRToEn.length; i++) {
			while(input.contains(HRToEn[i])) {
				input = input.replace(HRToEn[i], "a");
			}
		}
		
		bw.write(String.valueOf(input.length()));
		
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}