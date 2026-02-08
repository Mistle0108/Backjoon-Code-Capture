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
        HashMap<Integer, Integer> nList = new HashMap<Integer, Integer>();
    	String[] nTemp = br.readLine().split(" ");
    
    	for (int i = 0; i < n; i++) {
    		if(nList.containsKey(Integer.parseInt(nTemp[i]))) 
    			nList.put(Integer.parseInt(nTemp[i]), nList.get(Integer.parseInt(nTemp[i]))+1);
    		else 
    			nList.put(Integer.parseInt(nTemp[i]), 1);
        }
    	
    	int m = Integer.parseInt(br.readLine());
    	
    	String[] temp = br.readLine().split(" ");
    	
        for (int i = 0; i < temp.length; i++) {
        	if(nList.containsKey(Integer.parseInt(temp[i]))) {
        		bw.write(nList.get(Integer.parseInt(temp[i])) + " ");
        	}else {
        		bw.write(0 + " ");
        	}
		}
        bw.flush();
        
        br.close();
        bw.close();
    }
}
