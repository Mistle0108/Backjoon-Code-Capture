import java.io.*;

class Main {
	static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int[][] rectangle = new int[N][N];
    	for (int i = 0; i < N; i++) {
    		String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				rectangle[i][j] = temp.charAt(j) - 48;
			}
		}
        
    	divideNConquer(rectangle, N);
    	
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void divideNConquer(int[][] arr, int n) throws Exception {
    	if(n == 2) {
    		if(allEqual(arr)) {
    			bw.write(arr[0][0] + "");
    		}else {
    			bw.write("(" + arr[0][0] + arr[0][1] + arr[1][0] + arr[1][1] + ")");    			
    		}
    	} else if(allEqual(arr)){
    		bw.write(arr[0][0]+ "");
    	} else {
    		int half = n/2;
	    	
	    	int[][] temp1 = new int[half][half];
	    	int[][] temp2 = new int[half][half];
	    	int[][] temp3 = new int[half][half];
	    	int[][] temp4 = new int[half][half];
	    	
	    	for (int i = 0; i < half; i++) {
				for (int j = 0; j < half; j++) {
					temp1[i][j] = arr[i][j];
		            temp2[i][j] = arr[i][j + half];
		            temp3[i][j] = arr[i + half][j];
		            temp4[i][j] = arr[i + half][j + half];
				}
			}

	    	bw.write("(");
	    	divideNConquer(temp1, half);
	    	divideNConquer(temp2, half);
	    	divideNConquer(temp3, half);
	    	divideNConquer(temp4, half);
	    	bw.write(")");
    	}
    }
    
    static boolean allEqual(int[][] arr) {
    	int compare = arr[0][0];
    	
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(compare != arr[i][j]) return false;
			}
		}
    	return true;
    }
}