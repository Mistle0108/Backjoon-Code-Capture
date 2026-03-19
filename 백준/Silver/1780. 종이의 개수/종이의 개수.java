import java.io.*;

class Main {
	static BufferedWriter bw;
	static int[][] rectangle;
	static int count_zero = 0;
	static int count_one = 0;
	static int count_minus_one = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	rectangle = new int[N][N];
    	for (int i = 0; i < N; i++) {
    		String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				rectangle[i][j] = Integer.parseInt(temp[j]);
			}
		}
        
    	divide(0, 0, N);
    	
    	bw.write(count_minus_one+"\n");
    	bw.write(count_zero+"\n");
    	bw.write(count_one+"\n");
    	
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void divide(int x, int y, int n) throws Exception {
    	
    	 if(allEqual(x, y, n)){
    		if(rectangle[x][y] == 0) count_zero++;
    		else if(rectangle[x][y] == 1) count_one++;
    		else count_minus_one++;
    	} else {
    		int third = n/3;

    		for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divide(x + i * third, y + j * third, third);
				}
			}
    	}
    }
    
    static boolean allEqual(int x, int y, int n) {
    	int compare = rectangle[x][y];
    	
    	for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if(compare != rectangle[i][j]) return false;
			}
		}
    	return true;
    }
}