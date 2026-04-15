class Solution {
        static public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
    	
    	String[] time1 = pos.split(":");
    	int posTime = Integer.parseInt(time1[0])*60 + Integer.parseInt(time1[1]);  
        
    	String[] time2 = op_start.split(":");
        int opSTime = Integer.parseInt(time2[0])*60 + Integer.parseInt(time2[1]);
        
        String[] time3 = op_end.split(":");
        int opETime = Integer.parseInt(time3[0])*60 + Integer.parseInt(time3[1]);
        
        String[] time4 = video_len.split(":");
        int vETime = Integer.parseInt(time4[0])*60 + Integer.parseInt(time4[1]);
           
        // 오프닝 구간인지
		if(posTime >= opSTime && posTime <= opETime) {
			posTime = opETime;
		}
            
        for (int i = 0; i < commands.length; i++) {
        	if(commands[i].equals("prev")) {
        		posTime -= 10;
        		
        		// 0시작으로 돌아갔는지
        		if(posTime <= 0) {
        			posTime = 0;
        		}
        		// 오프닝 구간인지
        		if(posTime >= opSTime && posTime <= opETime) {
        			posTime = opETime;
        		}
        	} else {
        		posTime += 10;
        		// 영상의 마지막인지
        		if(posTime >= vETime) {
        			posTime = vETime;
        		}
        		
        		// 종료 구간인지
        		if(posTime >= opSTime && posTime <= opETime) {
        			posTime = opETime;
        		}
        	}
		}
        String answer = "";
        int min = posTime / 60;
        int sec = posTime % 60;
        answer = String.format("%02d:%02d", min, sec);
        
        return answer;
    }    
}