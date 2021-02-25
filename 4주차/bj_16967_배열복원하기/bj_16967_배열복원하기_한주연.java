import java.util.*;
import java.io.*;

public class Main {
	static int h,w,x,y;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	h = stoi(stk.nextToken());
    	w = stoi(stk.nextToken());
    	y = stoi(stk.nextToken());
    	x = stoi(stk.nextToken());
    	
    	arr = new int[h + y][w + x];

    	for(int i = 0; i < h + y; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < w + x; j++) {
    			arr[i][j] = stoi(stk.nextToken());
    		}
    	}
    	
    	for(int i = 0; i < h ; i++) {
    		for(int j = 0; j < w; j++) {
				// y, x 이상의 인덱스 부터 A 배열이 겹치므로, 그 차이를 구한다.
    			if(i >= y && j >= x) {
    				arr[i][j] -= arr[i - y][j - x]; 
    			}
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < h; i++) {
    		for(int j = 0; j < w; j++) {
    			sb.append(arr[i][j]).append(" ");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
    	br.close();
	}
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}