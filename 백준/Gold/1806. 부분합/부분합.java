import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		String[] input1 = br.readLine().split(" ");
		
		int N = Integer.parseInt(input1[0]);
		int S = Integer.parseInt(input1[1]);
		
		String[] input2 = br.readLine().split(" ");
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input2[i]); 
		}
		
		int length = Integer.MAX_VALUE;
		int start = 0;
        int sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += arr[i];

			while(sum >= S) {
				length = Math.min(length, i - start + 1);
				sum -= arr[start];
				start++;
			}
			
		}
		
		if (length == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(length + "");
        }
		
		bw.flush();
		bw.close();
		br.close();
	}
}
