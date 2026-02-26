import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	static int[] qArr;
	static int input;
	static int count;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        input = Integer.parseInt(br.readLine());
   		qArr = new int[input];
        
        nQueen(0);
        
        bw.write(count + "");
        
        bw.flush();
        bw.close();
        br.close();     
	}
	
    static void nQueen(int col) {
    	if(col == input) {
    		count++;
    		return;
    	}
    	
    	// 각 row당 col 만큼 반복
    	for (int row = 0; row < input; row++) {
    		qArr[col] = row;
    		if(canPlace(col)) {
    			nQueen(col + 1);
    		}
		}
    }
	
    // 같은 열도 아니고 대각선 상으로 겹치지 않을 때 True
    static boolean canPlace(int col) {
    	for (int i = 0; i < col; i++) {
    		
			if((qArr[i] == qArr[col])) {
				return false;
			} 
			if(Math.abs(i - col) == Math.abs(qArr[col] - qArr[i])){
				return false;
			}
		}
    	return true;
    }   
}