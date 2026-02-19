import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main {
	
	static int count = 0;
	static int countNum = 0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        
        int [] arr = new int[Integer.parseInt(input[0])];
        count = Integer.parseInt(input[1]);
        
        
        String[] temp = br.readLine().split(" ");
        
        for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
        
        mergeSort(arr, 0, arr.length-1);
        
        if(countNum == 0)
        	bw.write("-1");
        else
        	bw.write(countNum + "");
        
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
    
    static void mergeSort(int[] arr, int left, int right) {
    	
    	if (left >= right) return;
    	
    	int mid = (left + right) /2;
    	
    	if(right > left) {
    		mergeSort(arr, left, mid);
    		mergeSort(arr, mid + 1, right);
    		merge(arr, left, mid, right);
    	}
    }
    
    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
        	if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        	count--;
        	if(count == 0) countNum = temp[k-1];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
            count--;
        	if(count == 0) countNum = temp[k-1];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
            count--;
        	if(count == 0) countNum = temp[k-1];
        }

        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }
}