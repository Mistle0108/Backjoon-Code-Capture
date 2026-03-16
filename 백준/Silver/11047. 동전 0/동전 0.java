import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] input = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(input[0]);
    	int k = Integer.parseInt(input[1]);
    	
    	int[] coin = new int[n];
    	
    	for (int i = 0; i < coin.length; i++) {
    		coin[i] = Integer.parseInt(br.readLine());
		}
    	
    	int count = 0;
    	
    	for (int i = coin.length - 1; i >= 0; i--) {
    		count += k / coin[i];
            k %= coin[i];
		}
    	
    	bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();
    }
}