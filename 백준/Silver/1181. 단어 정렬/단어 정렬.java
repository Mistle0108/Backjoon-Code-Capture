
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
        
        HashSet<String> hs = new HashSet<String>();
        
        for (int i = 0; i < n; i++) {
			hs.add(br.readLine());
		}

        String[] arr = new String[hs.size()];
        
        
        int i = 0;
        for (String str : hs) {
			arr[i] = str;
			i++;
		}
        
        
        Arrays.sort(arr, (a,b) ->{
        	if(a.length() == b.length()) {
        		int j = 0;
        		while(true) {
        			if(a.charAt(j) != b.charAt(j)) break;
    				j++;
    			}
        		return a.charAt(j) - b.charAt(j); 
        	}        	
	        else {
	        	return a.length() - b.length();
	        }
        });
        
        for (int j = 0; j < arr.length; j++) {
			bw.write(arr[j] + "\n");
		}
        
        
        
        bw.flush();
        
        br.close();
        bw.close();
    }
	
}