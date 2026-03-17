import java.io.*;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int input1 = Integer.parseInt(br.readLine());
    	String[] input2 = br.readLine().split(" ");
    	
    	int[] waiting = new int[input1];
    	
    	for (int i = 0; i < input1; i++) {
			waiting[i] = Integer.parseInt(input2[i]);
		}
    	
    	Arrays.sort(waiting);
    	
    	int sum = 0;
    	int total = 0;
    	for (int i = 0; i < waiting.length; i++) {
			sum = sum + waiting[i];
			total += sum;
		}

    	bw.write(total+"");

        bw.flush();
        bw.close();
        br.close();
    }
}