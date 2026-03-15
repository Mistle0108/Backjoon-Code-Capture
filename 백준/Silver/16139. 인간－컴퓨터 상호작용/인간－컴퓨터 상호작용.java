import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String s = br.readLine();
    	
    	int q = Integer.parseInt(br.readLine());

    	for (int j = 0; j < q; j++) {
    		String[] input = br.readLine().split(" "); 
        	
        	String a = input[0];
        	int l = Integer.parseInt(input[1]);
        	int r = Integer.parseInt(input[2]);
    		int count = 0;
    		
    		for (int i = l; i <= r; i++) {
    			if(a.charAt(0) == s.charAt(i)) count++; 
    		}
        	bw.write(count + "\n");
		}

    	bw.write("");

        bw.flush();
        bw.close();
        br.close();
    }
}
