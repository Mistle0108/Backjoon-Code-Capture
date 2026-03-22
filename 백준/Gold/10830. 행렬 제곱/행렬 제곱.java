import java.io.*;

/* multiply(): 인자로 받은 두 행렬을 곱하는 함수 
 * pow(): 거듭제곱에 대한 분할정복을 수행할 함수
 * 거듭제곱의 지수를 2로 나누어 분할해나가면서 결과를 리턴한다.
 * */

class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input1 = br.readLine().split(" ");

		N = Integer.parseInt(input1[0]);
		long B = Long.parseLong(input1[1]);
		
		int[][] matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}

	    int[][] matrixRes = pow(matrix, B);
		
	    for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write((matrixRes[i][j] % 1000) + " ");
            }
            bw.write("\n");
        }
		
		bw.flush();
		bw.close();
		br.close();
	}	
	
	static int[][] pow(int[][] matrix, long B) {
		
		if(B == 1) return matrix;
		
		int[][] halfMat = pow(matrix, B/2);
		
		int[][] resultMat = multiply(halfMat, halfMat);
		
		if(B % 2 == 1) {
			resultMat = multiply(resultMat, matrix);
		}
		
		return resultMat;
	}
	
	static int[][] multiply(int[][] aMat, int[][] bMat) {
		
		int[][] resultMat = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					resultMat[i][j] += aMat[i][k] * bMat[k][j];
					resultMat[i][j] %= 1000;
				}
			}
		}
		return resultMat;
	}
	
}
