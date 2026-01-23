import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String tempString = "";
        
        String result = "";
        
        for (int i = 0; i < 5; i++) {
        	tempString += br.readLine() + "\n";
		}
        
        
        
        String [] tempArray = tempString.split("\n");
        
        
        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
        	maxLength = Math.max(maxLength, tempArray[i].length());
        }
        
        
        for(int i = 0; i < maxLength; i++) {
        	for(int k = 0; k < 5; k++) {
        		if(i > tempArray[k].length()-1) continue;
        		bw.write(tempArray[k].charAt(i));
        	}
        }
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}