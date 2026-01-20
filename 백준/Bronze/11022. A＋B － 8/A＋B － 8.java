import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String caseCount = br.readLine();

        int[] result = new int[Integer.parseInt(caseCount)];
        int[] aArray = new int[Integer.parseInt(caseCount)];
        int[] bArray = new int[Integer.parseInt(caseCount)];
        int idx = 0;

        for(int i = 0; i < Integer.parseInt(caseCount); i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            aArray[i] = Integer.parseInt(st.nextToken());
            bArray[i] = Integer.parseInt(st.nextToken());

            result[idx++] = aArray[i] + bArray[i];
        }

        for(int i = 0; i < Integer.parseInt(caseCount); i++){
            bw.write("Case #"+ (i+1) + ": " + aArray[i] + " + " + bArray[i] + " = "+ String.valueOf(result[i]));
            bw.newLine();
        }

        bw.flush();
	}	
}