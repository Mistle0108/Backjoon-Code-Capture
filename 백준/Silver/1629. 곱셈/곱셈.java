import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] input = br.readLine().split(" ");
    	
    	int A = Integer.parseInt(input[0]);
    	int B = Integer.parseInt(input[1]);
    	int C = Integer.parseInt(input[2]);
    	
    	
    	
    	bw.write(dnq(A,B,C) + "");
    	
        bw.flush();
        bw.close();
        br.close();
    }
    
    static long dnq(int A, int B, int C) {
    	if(B == 1) {
    		return A % C;
    	}
    	
    	long half = dnq(A, B / 2, C);

        if (B % 2 == 0) {
            return (half * half) % C;
        } else {
            return (half * half % C) * A % C;
        }
    }
}