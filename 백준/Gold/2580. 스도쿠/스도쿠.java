/*
 * 1. 빈 칸을 확인한다.
 * 2. 빈 칸에 1~9까지 입력한다.
 * 3. 각 입력마다 행, 열, 박스 체크를 진행한다.
 * 4. 틀렸다면 백트래킹
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

class Main {
	static int[][] arr;
	static ArrayList<int[]> arrBlank;
	static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	arr = new int[9][9];
    	arrBlank = new ArrayList<int[]>();
    	
        for (int i = 0; i < 9; i++) {
        	String[] input = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				if(arr[i][j] == 0) arrBlank.add(new int[]{i, j});
			}
		}
    	
        sudoku(0);
        
        bw.flush();
        bw.close();
        br.close();
	}
	
    static boolean  sudoku(int n) throws IOException{
    	if(n == arrBlank.size()) {
    		for (int i = 0; i < 9; i++) {
            	for (int j = 0; j < 9; j++) {
            		bw.write(arr[i][j] + " ");
            	}
            	bw.write("\n");
            }
    		return true;

    	}
    	
    	int row = arrBlank.get(n)[0];
    	int col = arrBlank.get(n)[1];

		for (int i = 1; i <= 9; i++) { // 1 ~ 9까지 입력한다.
			if(canPlace(i, row, col)) {
    			arr[row][col] = i;
    			if(sudoku(n+1))return true;
    			arr[row][col] = 0;
    		}
		}
		return false;
    }
	
    static boolean canPlace(int i, int row, int col) {
    	
    	for (int j = 0; j < 9; j++) {
			if(i == arr[row][j]) return false;
		}
    	
    	for (int j = 0; j < 9; j++) {
			if(i == arr[j][col]) return false;
		}
    	
    	// row / 3 =  0, 1, 2
    	// col / 3 =  0, 1, 2
    	
    	for (int j = (row / 3)*3; j < (row / 3)*3 + 3; j++) {
    		for (int k = (col / 3)*3; k < (col / 3)*3 + 3; k++) {
    			if(i == arr[j][k]) return false;
    		}
		}
    	    	
    	return true;
    }
}