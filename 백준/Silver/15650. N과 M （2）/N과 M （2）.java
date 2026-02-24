import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	static BufferedWriter bw;
	static int[] arr;
	static boolean[] visited;
	
	static int n;
	static int m;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] input = br.readLine().split(" ");
        
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
       
        arr = new int[m];
        visited = new boolean[n];
        
        for (int i = 0; i < visited.length; i++) {
        	visited[i] = false;
		}
        
        backTrack(0,1);
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
    
    static void backTrack(int depth, int start) throws IOException {
    	if(depth == m) {
    		for (int i = 0; i < arr.length; i++) {
    			bw.write(arr[i] + " ");
			}
    		bw.write("\n");
    		return;
    	}
    	
    	for (int i = start; i <= n; i++) {
    		arr[depth] = i;
    		backTrack(depth + 1, i + 1);
    	}
    	
    }
}