
import java.io.*;

class Main {
	
	static int blue = 0;
	static int white = 0;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int[][] rectangle = new int[N][N];
    	for (int i = 0; i < N; i++) {
    		String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				rectangle[i][j] = Integer.parseInt(temp[j]);
			}
		}
        
        divideNConquer(rectangle, N);
    	
    	bw.write(white + "\n");
    	bw.write(blue + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    
    // 1. 4등분한다.
    // 2. 모두 같은 수인지 체크한다.
    // 	2-1. 아니라면 계속 나눈다. 
    // 	2-2. 맞다면 종료
    
    
    static void divideNConquer(int[][] arr, int n) {
    	
    	if(n == 1) {
	    	for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j] == 1) blue++;
					else white++;
				}
			}
    	}else if(allEqual(arr)){	
    		if(arr[0][0] == 1) blue++;
    		else white++;
    		
    	} else {
    		int half = n/2;
	    	
	    	int[][] temp1 = new int[half][half];
	    	int[][] temp2 = new int[half][half];
	    	int[][] temp3 = new int[half][half];
	    	int[][] temp4 = new int[half][half];
	    	
	    	for (int i = 0; i < half; i++) {
				for (int j = 0; j < half; j++) {
					temp1[i][j] = arr[i][j];
				}
			}

	    	for (int i = 0; i < half; i++) {
				for (int j = 0; j < half; j++) {
					temp2[i][j] = arr[i+half][j];
				}
			}

	    	for (int i = 0; i < half; i++) {
				for (int j = 0; j < half; j++) {
					temp3[i][j] = arr[i][j+half];
				}
			}

	    	for (int i = 0; i < half; i++) {
				for (int j = 0; j < half; j++) {
					temp4[i][j] = arr[i+half][j+half];
				}
			}
	    	
	    	divideNConquer(temp1, half);
	    	divideNConquer(temp2, half);
	    	divideNConquer(temp3, half);
	    	divideNConquer(temp4, half);
	    	
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