
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        boolean[][] dohwaji = new boolean[100][100];
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	String[] colorPaper = br.readLine().split(" ");
        	
        	for(int j=0; j < 10;j++) {
        		for(int k=0; k < 10;k++) {
        			int x = Integer.parseInt(colorPaper[1])+j;
        			int y = Integer.parseInt(colorPaper[0])+k;
        			dohwaji[y][x] = true;
        		}
        	}
		}
        
        int extent = 0;
        
        for(int i=0; i < 100; i++) {
        	for(int j=0; j < 100; j++) {
        		if(dohwaji[i][j] == true) extent++;
        	}
        }
        
        bw.write(String.valueOf(extent));
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}