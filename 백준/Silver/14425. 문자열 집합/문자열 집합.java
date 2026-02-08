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
        
        List<String> nList = new ArrayList<String>();
        List<String> mList = new ArrayList<String>();
        
        for(int i = 0; i< n; i++) {
        	nList.add(br.readLine());
        }
        
        for(int i = 0; i< m; i++) {
        	mList.add(br.readLine());
        }
        
        int count = 0;
        
        for(String str: mList) {
        	if(nList.contains(str)) count++; 
        }
        
        bw.write(count + "");
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}