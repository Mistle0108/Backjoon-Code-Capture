import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input1 = br.readLine().split(" ");
        
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        
        String[] inputNumber = br.readLine().split(" ");
        
        int[] nums = new int[inputNumber.length];
        
        for(int i = 0; i < nums.length; i++) {
        	nums[i] = Integer.parseInt(inputNumber[i]);
        }
        
        int min = m;
        int minSum = 0;
        int firstPickIdx = -1;
        int secondPickIdx = -1;
        
        for (int i = 0; i < n; i++) {
        	firstPickIdx = i;
        	for (int j = 0; j < n; j++) {
        		secondPickIdx = j;
        		for (int k = 0; k < n; k++) {
        			if(j == firstPickIdx || k == firstPickIdx || k == secondPickIdx) continue;
        			
        			int sum = nums[firstPickIdx] + nums[secondPickIdx]+ nums[k];
        			
            		if(sum <= m && m - sum < min) {
            			min = m - sum;
            			minSum = sum;
            		}
        		}
    		}
        	firstPickIdx = -1;
        	secondPickIdx = -1;
		}
        
        bw.write(String.valueOf(minSum));
               
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}