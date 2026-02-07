import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        
        int[] arr = new int[n];
        int[] arrIdx = new int[n];
        
        
        for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			arrIdx[i] = arr[i]; 
		}
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        Arrays.sort(arrIdx);
        
        
        int k = 0;
        for(int i = 0; i < arrIdx.length; i++) {
        	
        	if(!hm.containsKey(arrIdx[i])) hm.put(arrIdx[i], k++); 
        	
        }
        
        
        for(int i = 0; i < arr.length; i++) {
        	bw.write(hm.get(arr[i]) +" ");
        }
               
        bw.flush();
        
        br.close();
        bw.close();
    }
}
