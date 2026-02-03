import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        
        int[] nArray = new int[input];
        
        for (int i = 0; i < nArray.length; i++) {
        	nArray[i] = Integer.parseInt(br.readLine());
		}
        mergeSort(nArray, 0, nArray.length-1);
        
        for (int i = 0; i < nArray.length; i++) {
        	bw.write(nArray[i] +"\n");
        }
        
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
	static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;  // 원소 1개면 종료

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);       // 왼쪽 정렬
        mergeSort(arr, mid + 1, right);  // 오른쪽 정렬

        merge(arr, left, mid, right);    // 병합
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;      // 왼쪽 시작
        int j = mid + 1;   // 오른쪽 시작
        int k = 0;         // temp 인덱스

        // 두 부분 배열 비교
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 왼쪽 남은 값
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 오른쪽 남은 값
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 원래 배열에 복사
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }
	
}
