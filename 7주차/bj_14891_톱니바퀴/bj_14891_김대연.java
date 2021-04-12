import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] gears = new String[4];
		int[][] status = new int[4][2]; 
		for(int i = 0; i < 4; i++) {
			gears[i] = br.readLine();
			status[i][0] = 2; //right
			status[i][1] = 6; //left
		}
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int[] flag = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken())-1;
			int rotate = Integer.parseInt(st.nextToken()); // 1 clockwise, -1 counter..
			flag[id] = rotate;
			for(int j = 1; j <= 3; j++) {
				if(id-j >= 0) {					
					if(gears[id-j].charAt(status[id-j][0]) 
							!= gears[id-j+1].charAt(status[id-j+1][1])) {
						flag[id-j] = j%2==1? -rotate: rotate;
					} else break;
				}
			}
			for(int j = 1; j <= 3; j++) {
				if(id+j < 4) {
					if(gears[id+j].charAt(status[id+j][1]) 
							!= gears[id+j-1].charAt(status[id+j-1][0])) {
						flag[id+j] = j%2==1? -rotate: rotate;
					}else break;
				}
			}
			for(int k = 0; k < 4; k++) {
				if(flag[k] != 0) {
					rotation(flag[k], status, k);
				}
			}
			
		}
		int answer = 0;
		for(int i = 0; i < 4; i++) {
			int north = (status[i][1]+2)%8;
			if(gears[i].charAt(north) == '1') {
				answer += 1<<i;
			}
		}
		System.out.println(answer);
		br.close();
	}
	static void rotation(int ori, int[][] status, int id) {
		if(ori == -1) {
			status[id][0] = (status[id][0]+1) % 8;
			status[id][1] = (status[id][1]+1) % 8;
		}else {
			status[id][0] = (status[id][0]-1 + 8) % 8;
			status[id][1] = (status[id][1]-1 + 8) % 8;				
		}
	}

}
