import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        bw.write((int)Math.pow(2, input) - 1 + "\n");
        
        hanoi(input, 1, 3, 2);
		
        bw.flush();
        bw.close();
        br.close();
        
	}
	
	static void hanoi(int n, int A, int B, int C) throws IOException  {
		if(n == 1) {
			bw.write(A + " " + B + "\n");
			return;
		}
			
		hanoi(n-1, A, C, B);
		bw.write(A + " " + B + "\n");
		hanoi(n-1, C, B, A);	
    }
}