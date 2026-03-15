import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String s = br.readLine();
    	
    	int q = Integer.parseInt(br.readLine());

    	int[][] dp = new int[26][s.length()];
    	
    	for (int i = 0; i < 26 ; i++) { // 모든 문자열에 대해
    		
    		dp[i][0] = (s.charAt(0) == ('a' + i)) ? 1 : 0;
    		
			for(int j = 1; j <s.length(); j++) {
				dp[i][j] = dp[i][j-1] + (('a' + i) == s.charAt(j)? 1 : 0);   
			}
		}
    	
    	for (int i = 0; i < q; i++) {
    		String[] temp = br.readLine().split(" ");
    		
    		String a = temp[0];
    		int l = Integer.parseInt(temp[1]);
    		int r = Integer.parseInt(temp[2]);
    		
    		int result = dp[a.charAt(0) - 97][r];
    		if(l > 0) result -= dp[a.charAt(0) - 97][l-1];
    		
    		bw.write(result + "\n");
		}

    	bw.write("");

        bw.flush();
        bw.close();
        br.close();
    }
}