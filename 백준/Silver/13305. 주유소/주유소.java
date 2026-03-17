
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String input1 = br.readLine();
    	String[] input2 = br.readLine().split(" ");
    	String[] input3 = br.readLine().split(" ");
    	
    	long minFuel = Long.parseLong(input3[0]);
    	
    	long sum = 0;
    	
    	for (int i = 0; i < input2.length; i++) {
    		long currentPrice = Long.parseLong(input3[i]);
            if (currentPrice < minFuel) {
                minFuel = currentPrice;
            }
			sum += minFuel*Integer.parseInt(input2[i]);
		}
    	
    	bw.write(sum + "");

        bw.flush();
        bw.close();
        br.close();
    }
}