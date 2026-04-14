import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int x = 0;
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length-1;

		int fit = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < fit) {
                fit = Math.abs(sum);
                answer1 = arr[left];
                answer2 = arr[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(answer1 + " " + answer2);
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}