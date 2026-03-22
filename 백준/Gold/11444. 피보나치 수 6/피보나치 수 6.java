import java.io.*;

class Main {
	static final int mod = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long input = Long.parseLong(br.readLine());
		
		long[][] fibMat = new long[2][2];
		
		fibMat[0][0] = 1;
		fibMat[0][1] = 1;
		fibMat[1][0] = 1;
		fibMat[1][1] = 0;
		
		long[][] result = new long[2][2];
		
		result = pow(fibMat,input);
		
		bw.write(result[0][1]%mod+""); 
		
		bw.flush();
		bw.close();
		br.close();
	}	 
	
	static long[][] pow(long[][] mat, long n) {
		
		if (n == 0) {
		    return new long[][]{
		        {1, 0},
		        {0, 1}
		    };
		}
		
		if(n == 1) return mat;
		
		long[][] half = pow(mat, n/2);
		
		long[][] result = multiply(half, half);
		
		if(n % 2 == 1) {
			result = multiply(result, mat);
		}
		
		return result;
	}
	
	
	static long[][] multiply(long[][] mat1, long[][] mat2){
		long[][] result = new long[2][2];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result[i][j] += mat1[i][k] * mat2[k][j];
					result[i][j]%=mod;
				}
			}
		}
		
		return result;
	}
}