import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] tri = new int[3];
        
        for(int i=0; i <3; i++) {
        	tri[i] = Integer.parseInt(br.readLine());
        }
        
        if((tri[0] + tri[1] + tri[2]) != 180) {
        	bw.write("Error");
        } else {
        	if(tri[0] == 60 && tri[1] == 60 && tri[2] == 60) {
        		bw.write("Equilateral");
        	}else if(tri[0] == tri[1] || tri[1] == tri[2] || tri[0] == tri[2]) {
        		bw.write("Isosceles");
        	}else {
        		bw.write("Scalene");
        	}
        }
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}