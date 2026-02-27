import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

class Main {
	
	static int[][] arr;
	static boolean[] member;
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	int input = Integer.parseInt(br.readLine());

    	arr = new int[input][input];
    	member = new boolean[input];
    	
    	for (int i = 0; i < input; i++) {
    		String[] input2 = br.readLine().split(" ");
			for (int j = 0; j < input; j++) {
				arr[i][j] = Integer.parseInt(input2[j]);
			}
		}

    	recursion(0, 0);

    	bw.write(min + "");
    	
        bw.flush();
        bw.close();
        br.close();
	}
	
    static void recursion(int start, int depth) {   	
    	if(depth == arr.length/2) {
    		synergy();
    		return;
    	}
    	
    	for (int i = start; i < arr.length; i++) {
    		member[i] = true;
    		recursion(i+1, depth+1);
    		member[i] = false;
		}
    }
    
    static void synergy() {
    	int team1 = 0;
    	int team2 = 0;
    	
    	for (int i = 0; i < arr.length; i++) {
    	    for (int j = i + 1; j < arr.length; j++) {

    	        if (member[i] && member[j]) {
    	        	team1 += arr[i][j] + arr[j][i];
    	        }
    	        else if (!member[i] && !member[j]) {
    	            team2 += arr[i][j] + arr[j][i];
    	        }
    	    }
    	}

    	min = Math.min(min, Math.abs(team1 - team2));
    }
    
}