import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = 0;
        int b = 0;
        
        while(true) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        	
            if(a == 0 && b == 0) break;
            
        	bw.write(String.valueOf((a + b)));
			bw.newLine();
        	
		}
        
        bw.flush();
	}	
}