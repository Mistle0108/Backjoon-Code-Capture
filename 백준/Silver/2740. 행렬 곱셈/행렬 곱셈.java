import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input1 = br.readLine().split(" ");

		int N1 = Integer.parseInt(input1[0]);
		int M1 = Integer.parseInt(input1[1]);
		
		int[][] arr1 = new int[N1][M1];
		
		for (int i = 0; i < N1; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < M1; j++) {
				arr1[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		String[] input2 = br.readLine().split(" ");

		int N2 = Integer.parseInt(input2[0]);
		int M2 = Integer.parseInt(input2[1]);
		
		int[][] arr2 = new int[N2][M2];
		
		for (int i = 0; i < N2; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < M2; j++) {
				arr2[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		int[][] result = new int[N1][M2];
		
        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < M2; j++) {
                for (int k = 0; k < M1; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < M2; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
		
		
		bw.write("");
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
