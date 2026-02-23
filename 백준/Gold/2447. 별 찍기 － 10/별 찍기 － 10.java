
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
	static char [][] arr;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int input = Integer.parseInt(br.readLine());
        
        arr = new char[input][input];
        
        draw(0, 0, input, false);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
        
        br.close();
        
	}
	
    static void draw(int x, int y, int size, boolean blank) {

        if (blank) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        int count = 0;

        for (int i = x; i < x + size; i += newSize) {
            for (int j = y; j < y + size; j += newSize) {
                count++;
                if (count == 5) { // 가운데
                    draw(i, j, newSize, true);
                } else {
                    draw(i, j, newSize, false);
                }
            }
        }
    }
}