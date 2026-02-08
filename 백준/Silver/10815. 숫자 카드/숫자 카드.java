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
        Set<Integer> nSet = new HashSet<Integer>();
    	String[] nTemp = br.readLine().split(" ");
    
    	for (int i = 0; i < n; i++) {
    		nSet.add(Integer.parseInt(nTemp[i]));
        }
        
    	int m = Integer.parseInt(br.readLine());
    	Set<Integer> mSet = new LinkedHashSet<Integer>();
        String[] mTemp = br.readLine().split(" ");
        
        for (int i = 0; i < m; i++) {
        	mSet.add(Integer.parseInt(mTemp[i]));
		}
        
        for(int k: mSet) {
        	if(nSet.contains(k)) bw.write("1");
        	else bw.write("0");
        	
        	bw.write(" ");
        }
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}