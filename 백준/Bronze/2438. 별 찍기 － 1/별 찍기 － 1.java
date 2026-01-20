import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String caseCount = br.readLine();

        for(int i = 0; i < Integer.parseInt(caseCount); i++){
        	for(int j = 0; j <= i; j++) {
        		bw.write("*");
        	}
        	bw.newLine();
        }

        bw.flush();
	}	
}