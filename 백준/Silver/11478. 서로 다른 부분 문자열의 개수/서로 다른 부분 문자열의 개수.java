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
        
        String input = br.readLine();
        
        Set<String> set = new HashSet<String>();
        
        for(int i = 1; i <= input.length(); i++) {
        	for(int j = 0; j < input.length(); j++) {
        		if(j + i <= input.length()) set.add(input.substring(j, j+i));
        	}
        }
        
        bw.write(set.size() + "");
        
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}

