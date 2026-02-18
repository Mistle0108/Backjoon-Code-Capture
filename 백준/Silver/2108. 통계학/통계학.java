import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        
        int[] arr = new int[input];
        
        double sum = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        // 입력
        for (int i = 0; i < input; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	sum += arr[i];         	
		}

        // 정렬
        Arrays.sort(arr);
        
        
        // 각 배열의 값과 빈도를 hm에 입력
        for (int i = 0; i < arr.length; i++) {
        	if(!hm.containsKey(arr[i])) {
        		hm.put(arr[i], 1);        		
        	}else {
        		hm.put(arr[i], hm.get(arr[i]) + 1);
        	}
		}
        
        
        // 최빈값을 구함
        int max = hm.get(arr[0]);
       
        for (int i = 1; i < arr.length; i++) {
            if (hm.get(arr[i]) > max) {
                max = hm.get(arr[i]);
            }
        }
        
        int[] modeArr = new int[arr.length];
        
        Arrays.fill(modeArr, 0);
        
        int k = 0;
        // 최빈값을 가지고 있는 값들로 modeArr 구성
        for (int i = 0; i < arr.length; i++) {
			if(hm.get(arr[i]) == max) {
				if(i != 0 && arr[i-1] != arr[i]) {
					modeArr[k] = arr[i];
					k++;
				}else if(i == 0){
					modeArr[k] = arr[i];
					k++;
				}
			}
		}
        
        
        bw.write(Math.round((sum / arr.length * 10)/ 10.0) + "\n");
        bw.write(arr[arr.length/2] + "\n");
        
        if(k > 1) 
        	bw.write(modeArr[1]+ "\n");
        else 
        	bw.write(modeArr[0]+ "\n");
        bw.write(arr[arr.length-1] - arr[0] + "");
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}