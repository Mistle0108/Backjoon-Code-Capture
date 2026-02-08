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
        
        Set<String> nameSet = new HashSet<String>();
        
        for (int i = 0; i < input; i++) {
        	String[] temp = br.readLine().split(" ");
        
        	if(temp[1].equals("enter")) nameSet.add(temp[0]);
        	else if(temp[1].equals("leave") && nameSet.contains(temp[0])) nameSet.remove(temp[0]); 
		}
       
        String[] nameArr = nameSet.toArray(new String[0]); 
        
        Arrays.sort(nameArr, (a,b) -> b.compareTo(a));
        
        for(String str: nameArr) {
        	bw.write(str + "\n");
        }
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}

