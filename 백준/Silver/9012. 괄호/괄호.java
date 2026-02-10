
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

        int input = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < input; i++) {
        	Stack stack = new Stack();
        	String temp = br.readLine();
        	
        	int sum = 0;
        	boolean isOver = false;
        	
        	for (int j = 0; j < temp.length(); j++) {
        		char a = temp.charAt(j);
        		if(a == '(') {
        			sum++;
        		} else {
        			sum--;
        			if(sum < 0) {
        				isOver = true;
        				break;
        			}
        		}
        		
    		}
        	
        	if(sum==0 && isOver == false) {
        		bw.write("YES\n");
        	}else {
        		bw.write("NO\n");
        	}
        	isOver = false;
        	
        	sum = 0;
		}
        
        bw.write("");
        
        
        bw.flush();
        
        br.close();
        bw.close();
	}
}