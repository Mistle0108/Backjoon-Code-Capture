import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [][] score = {
				{"A+","4.5"},
				{"A0","4.0"},
				{"B+","3.5"},
				{"B0","3.0"},
				{"C+","2.5"},
				{"C0","2.0"},
				{"D+","1.5"},
				{"D0","1.0"},
				{"F","0.0"}};

		float total = 0;

		float credit = 0;	// 과목 평점에 따른 점수
		float creditCount = 0; // 학점의 총합
	
		for(int i=0; i<20; i++) {
			String [] subject = br.readLine().split(" ");
			
			if(subject[2].equals("P")) {
				continue;
			}
			
			for(int k=0; k<score.length; k++) {
				if(subject[2].equals(score[k][0])) {
					credit = Float.parseFloat(score[k][1]);
					break;
				}
			}
									
			creditCount += Float.parseFloat(subject[1]);
			total += (Float.parseFloat(subject[1]) * credit); 
			
		}
		
		System.out.printf("%.6f%n", total/creditCount);
		//bw.write(String.valueOf(total/creditCount));
		
        bw.flush();                   
        
        br.close();
        bw.close();
	}	
}