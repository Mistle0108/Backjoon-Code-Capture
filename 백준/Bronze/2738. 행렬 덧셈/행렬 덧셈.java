import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String[] firstLine = br.readLine().split(" ");
        
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        
        int [][] a = new int[n][m];
        int [][] b = new int[n][m];
        
        int [][] result = new int[n][m];
        
        for(int i=0; i<n; i++) {
        	String[] temp = br.readLine().split(" ");
        	for(int k=0; k<m; k++) {
        		result[i][k] += Integer.parseInt(temp[k]);
        	}
        }
        
        for(int t=0; t<n; t++) {
        	String[] temp = br.readLine().split(" ");
        	for(int k=0; k<m; k++) {
        		result[t][k] += Integer.parseInt(temp[k]);
        	}
        }
	
        for(int t=0; t<n; t++) {
        	for(int k=0; k<m; k++) {
        		bw.write(result[t][k] + " "); 
        	}
        	bw.write("\n");
        }
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}