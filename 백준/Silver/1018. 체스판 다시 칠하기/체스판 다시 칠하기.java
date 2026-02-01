
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
        
        String[] input = br.readLine().split(" ");
        
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
        		
        
        String [] line = new String[height];
        
        for(int i=0; i<height; i++) {
    		line[i] = br.readLine();
    		
        }      

        int chCount = 0;
        int chMin = height * width;
        
        for(int h=0; h<=height-8; h++) {
        	for(int w=0; w<=width-8; w++) {
        
		        for(int k=0; k<2; k++) {	// 검정 흰색 체크
		        	
			        for(int i=0; i<8; i++) {
			        	for(int j=0; j<8; j++) {
			        		if(k == 0) { //0,0이 검정일때
			        			if((i+j)%2 == 0) {
			        				if(line[i+h].charAt(j+w) == 'W') chCount++;
			        			} else {
			        				if(line[i+h].charAt(j+w) == 'B') chCount++;
			        			}
			        		}else {  //0,0이 흰색일때
			        			if((i+j)%2 == 0) {
			        				if(line[i+h].charAt(j+w) == 'B') chCount++;
			        			} else {
			        				if(line[i+h].charAt(j+w) == 'W') chCount++;
			        			}	
			        		}
			        		
			            }
			        }
			        if(chCount < chMin) {
			        	chMin = chCount;
			        }
			        chCount=0;
		        }
		        
        	}
        }
        
        
        bw.write(String.valueOf(chMin));
        
        
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
	
}