import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;
        while ((line = br.readLine()) != null) {
            int k = Integer.parseInt(line);
            int n = (int)Math.pow(3, k);
            
            char[] arr = new char[n];
                   
            for (int i = 0; i < n; i++) {
    			arr[i] =  '-';
    		}
        
            cantor(arr, 0, n);
            
            System.out.println(arr);
        }
       
    }
    
    static void cantor(char[] arr, int start, int length) {
        if (length == 1) return;

        int third = length / 3;

        for (int i = start + third; i < start + 2 * third; i++) {
            arr[i] = ' ';
        }

        cantor(arr, start, third);
        cantor(arr, start + 2 * third, third);
    }
}