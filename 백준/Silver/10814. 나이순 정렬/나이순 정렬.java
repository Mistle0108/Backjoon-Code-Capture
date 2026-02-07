import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
	public static class member{
		public int age;
		public String name;
		public int idx;
	} 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        member[] arr = new member[n];
        
        for (int i = 0; i < n; i++) {
        	String[] temp = br.readLine().split(" ");
        	
        	member mem = new member();
        	
        	mem.age = Integer.parseInt(temp[0]);
        	mem.name = temp[1];
        	mem.idx = i;
        	
        	arr[i] = mem;
		}
  
        Arrays.sort(arr, (a, b)->{
        	if(a.age == b.age) {
        		return a.idx - b.idx;
        	} else {
        		return a.age - b.age;
        	}
        });
        
        for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i].age + " " + arr[i].name + "\n");
		}
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}