import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	static char[][] star;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	n = stoi(br.readLine());
    	star = new char[n][n];
		// 별의 크기 만큼 공백으로 초기화한다.
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			star[i][j] = ' ';
    		}
    	}
		// 별 찍기
    	GetStar(n,0,0);
		// 출력
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			sb.append(star[i][j]);
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    	br.close();
	}
	
	static void GetStar(int size, int y, int x) {
		if(size == 1) {
			star[y][x] = '*';
			return;
		}
		// 각 방향으로 찍을 위치를 준다. 제일 중간은 비어있으므로 CONTINUE로 넘긴다.  
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1)
					continue;
				GetStar(size / 3, y + size / 3 * i, x + size / 3 * j);
			}
		}
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}