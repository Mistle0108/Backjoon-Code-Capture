
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] pArr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			
			pArr[i][0] = Integer.parseInt(temp[0]);
			pArr[i][1] = Integer.parseInt(temp[1]);
		}
        Arrays.sort(pArr, (o1, o2) -> {
        	if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
              
        for (int i = 0; i < n; i++) {
			bw.write(pArr[i][0] + " " + pArr[i][1] + "\n");
		}
       
        bw.flush();
        
        br.close();
        bw.close();
    }
	
}
