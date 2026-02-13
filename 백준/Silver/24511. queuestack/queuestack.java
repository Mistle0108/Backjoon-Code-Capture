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

        Queue<Integer> queue = new LinkedList<>();
        
        // 입력 처리 - Start
        int input1 = Integer.parseInt(br.readLine());
        String [] input2 = br.readLine().split(" ");
        String [] input3 = br.readLine().split(" ");
        
        int[] arrA = new int[input1];	// 자료구조 플래그
        int[] arrB = new int[input1];	// 값 배열

        for (int i = 0; i < input1; i++) {
        	arrA[i] = Integer.parseInt(input2[i]);
        	arrB[i] = Integer.parseInt(input3[i]);
		}
        
        for (int i = input1; i > 0; i--) {
        	if(arrA[i-1] == 0) {
        		queue.add(arrB[i-1]); 
        	}
        }
        
        int input4 = Integer.parseInt(br.readLine());
        String [] input5 = br.readLine().split(" ");
        
        int[] arrM = new int[input4];
        
        for (int i = 0; i < input4; i++) {
        	arrM[i] =  Integer.parseInt(input5[i]);
        }     
        // 입력 처리 - End


        // 삽입할 개수만큼
        for (int i = 0; i < input4; i++) {
        	queue.add(arrM[i]);
        	bw.write(queue.poll() + " ");
        }
        bw.flush();
        
        br.close();
        bw.close();
	}
}