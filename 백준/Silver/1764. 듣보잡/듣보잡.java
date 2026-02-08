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
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        Set<String> nSet = new HashSet<String>();
        List<String> resultList = new ArrayList<String>();
    	
    	for (int i = 0; i < n; i++) {
    		String nTemp = br.readLine();
    		nSet.add(nTemp);
        }
        
    	for (int i = 0; i < m; i++) {
    		String temp = br.readLine();
    		if(nSet.contains(temp)){
    			resultList.add(temp);
    		}
        }
    	
    	String[] rArr = resultList.toArray(new String[0]);
    	
    	Arrays.sort(rArr);
    	
    	bw.write(rArr.length + "\n");
    	
    	for (int i = 0; i < rArr.length; i++) {
			bw.write(rArr[i] + "\n");
		}
    	
    	
        bw.flush();
        
        br.close();
        bw.close();
    }
}