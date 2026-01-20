import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String caseCount = br.readLine();

        int[] result = new int[Integer.parseInt(caseCount)];   // 결과 저장용
        int idx = 0;

        for(int i = 0; i < Integer.parseInt(caseCount); i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            result[idx++] = a + b;  // 계산 결과만 저장
        }

        for(int i = 0; i < Integer.parseInt(caseCount); i++){
            bw.write("Case #"+ (i+1) + ": " + String.valueOf(result[i]));
            bw.newLine();
        }

        bw.flush();
	}	
}