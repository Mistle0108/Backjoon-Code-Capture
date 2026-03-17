
import java.io.*;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int input1 = Integer.parseInt(br.readLine());
    	
    	int[][] meeting = new int[input1][2];
    	
    	for (int i = 0; i < input1; i++) {
    		String[] input2 = br.readLine().split(" ");
			meeting[i][0] = Integer.parseInt(input2[0]);
			meeting[i][1] = Integer.parseInt(input2[1]);
		}
    	
    	Arrays.sort(meeting, (a, b)-> {
    		if(a[1] == b[1]) {
    			return a[0] - b[0];
    		}else {
    			return a[1] - b[1];
    		}
    	});
    	   	
    	
    	int count = 0;
    	int currentEndTime = 0;
    	
        for (int i = 0; i < input1; i++) {
            if (meeting[i][0] >= currentEndTime) {
            	currentEndTime = meeting[i][1];
                count++;
            }
        }
    	
    	bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();
    }
}