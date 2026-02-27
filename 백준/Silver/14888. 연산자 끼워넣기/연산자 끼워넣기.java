import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] nums;
	static int[] opers;
	static int result;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	int input1 = Integer.parseInt(br.readLine());
    	String[] input2 = br.readLine().split(" ");
    	String[] input3 = br.readLine().split(" ");
    	
    	nums = new int[input1];
    	opers = new int[4];
    	
    	for (int i = 0; i < input1; i++) {
    		nums[i] = Integer.parseInt(input2[i]);
		}
    	
    	for (int i = 0; i < 4; i++) {
    		opers[i] = Integer.parseInt(input3[i]);
		}

    	recursion(1, nums[0]);
    	
    	bw.write(max + "\n" + min);
    	
        bw.flush();
        bw.close();
        br.close();
	}
	
    static void recursion(int n, int current) {
    	if(n == nums.length) {
    		max = Math.max(current, max);
    		min = Math.min(current, min);
    		return;
    	}
    
    	// 연산자 수만큼 반복
    	for (int i = 0; i < 4; i++) {
        	if(opers[i] > 0) {
        		opers[i]--;
        		
        		int next = current;
        		
    	    	if(i == 0) next = current + nums[n];
    	    	else if (i == 1) next = current - nums[n];
    	    	else if (i == 2) next = current * nums[n];
    	    	else next = current / nums[n];
    	    	
    	    	recursion(n + 1, next);
    	    	
    	    	opers[i]++;
        	}
		}
    }
}