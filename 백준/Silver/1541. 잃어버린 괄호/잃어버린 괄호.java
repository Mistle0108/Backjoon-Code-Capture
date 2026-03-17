import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String input = br.readLine();
    	
    	List<String> list = new ArrayList<>();
    	String number = "";
    	
    	for (int i = 0; i < input.length(); i++) {
    		if(input.charAt(i) == '-' || input.charAt(i) == '+') {
    			list.add(number);
    			list.add(String.valueOf(input.charAt(i)));
    			number = "";
    		}else {
    			number += input.charAt(i);
    		}
		}
    	
    	list.add(number);
    	
    	int sum = Integer.parseInt(list.get(0));
    	
    	boolean flag = false;
    	
    	for (int i = 1; i < list.size(); i++) {
    		if(list.get(i).equals("-")) {
    			flag = true;
    			continue;
    		}else if(list.get(i).equals("+")) {
    			continue;
    		}
    		
    		if(flag) {
    			sum -= Integer.parseInt(list.get(i));
    		}else {
    			sum += Integer.parseInt(list.get(i));
    		}
		}
    	
    	bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();
    }
}