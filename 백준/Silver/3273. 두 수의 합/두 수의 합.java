import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int x = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length-1;
		int mid = (left + right) / 2;

		int count = 0;
		
		while(left < right) {
			
			int sum = arr[left] + arr[right];
			
			if(sum == x) {
				left++;
				right--;
				count++;
			}else if(sum > x) {
				right--;
			}else {
				left++;
			}
		}
		
		bw.write(count + "");

		bw.flush();
		bw.close();
		br.close();
	}
}