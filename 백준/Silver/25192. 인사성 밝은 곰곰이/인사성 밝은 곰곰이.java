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
        
        HashMap hm = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < input; i++) {
        	String temp = br.readLine();
        	
        	if(Objects.equals(temp, "ENTER")) {
        		hm.clear();
        	} else {
        		if(!hm.containsKey(temp)) {
        			hm.put(temp, temp);
        			count++;
        		}
        	}
		}
        
        bw.write(count+"");
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}