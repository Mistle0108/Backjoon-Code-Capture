import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        
        HashSet hs = new HashSet<>();
        
        hs.add("ChongChong");
        
        for (int i = 0; i < input; i++) {
        	String [] temp = br.readLine().split(" ");
        	
        	String a = temp[0];
        	String b = temp[1];
        	
        	if(hs.contains(a) || hs.contains(b)) { 
        		hs.add(a); 
        		hs.add(b);
        	}
        	
		}
        
        bw.write(hs.size()+"");
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}