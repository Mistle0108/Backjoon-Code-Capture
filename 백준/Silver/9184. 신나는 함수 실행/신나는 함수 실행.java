import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

class Main {
	static int[][][] arr = new int[21][21][21];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	while(true) {
    		String[] input = br.readLine().split(" ");
    		int a = Integer.parseInt(input[0]);
    		int b = Integer.parseInt(input[1]);
    		int c = Integer.parseInt(input[2]);
    		
    		if(a == -1 && b == -1 && c == -1) break;
   		
    		bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c) +"\n");
    	}

        bw.flush();
        bw.close();
        br.close();
	}
    static int w(int a, int b, int c) {
    	
    	if(a <= 0 || b <= 0 || c <= 0) return 1;
    	
    	if(a > 20 || b > 20 || c > 20) return w(20, 20, 20);
    	
    	if (arr[a][b][c] != 0)
            return arr[a][b][c];

        if (a < b && b < c) {
            arr[a][b][c] =
                    w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            arr[a][b][c] =
                    w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return arr[a][b][c];
		
    }
    
}