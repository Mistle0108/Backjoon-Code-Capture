import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int [] correctWhiteChessCount = {1,1,2,2,2,8}; 
						
		String [] inputWhiteChessCount = br.readLine().split(" ");
        
		for(int i = 0; i < correctWhiteChessCount.length; i++) {
			int gap =  correctWhiteChessCount[i] - Integer.parseInt(inputWhiteChessCount[i]);	
			bw.write(gap + " ");
		}
		
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}