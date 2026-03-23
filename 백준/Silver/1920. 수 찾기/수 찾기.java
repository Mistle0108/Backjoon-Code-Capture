import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input1 = Integer.parseInt(br.readLine());
        String[] numbers1 = br.readLine().split(" ");
        
        int[] arr1 = new int[input1];
        
        for (int i = 0; i < input1; i++) {
        	arr1[i] = Integer.parseInt(numbers1[i]);
		}
        
        Arrays.sort(arr1);
        
        int input2 = Integer.parseInt(br.readLine());
        String[] numbers2 = br.readLine().split(" ");
        
        int[] arr2 = new int[input2];
        
        for (int i = 0; i < input2; i++) {
        	arr2[i] = Integer.parseInt(numbers2[i]);
		}
        
        
        for (int i = 0; i < arr2.length; i++) {
        	bw.write(search(arr1, arr2[i]) + "\n");
		}
        
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static int search(int[] arr ,int n) {
    	
    	int left = 0;
    	int right = arr.length-1;
    	
    	while(left <= right) {
    		int mid = (left + right) / 2;
    		
    		if(arr[mid] == n) {
    			return 1; 
    		}else if(arr[mid] < n) {
    			left = mid + 1;
    		}else {
    			right = mid - 1;
    		}
    	}
    	
    	return 0;
    }
    
}