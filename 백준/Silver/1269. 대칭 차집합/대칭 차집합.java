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
        
        Set<Integer> nSet = new HashSet<Integer>();
        Set<Integer> mSet = new HashSet<Integer>();
        
        String[] nTemp = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
			nSet.add(Integer.parseInt(nTemp[i]));
		}
        
        String[] mTemp = br.readLine().split(" ");
        
        for (int i = 0; i < m; i++) {
			mSet.add(Integer.parseInt(mTemp[i]));
		}
        
        
        Set<Integer> totalSet = new HashSet<Integer>();
        
        for(int i:nSet) {
        	if(!mSet.contains(i)) totalSet.add(i);
        }
        
        for(int i:mSet) {
        	if(!nSet.contains(i)) totalSet.add(i);        
        }
        
        bw.write(totalSet.size() + "");
        
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}
