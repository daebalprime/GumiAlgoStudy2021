package a_6weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_14499_주사위굴리기_봉대현 {

	static int[][] map;
	// 동 서 북 남
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s[] = in.readLine().split(" ");
		// map크기
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int x = Integer.parseInt(s[2]);// x좌표
		int y = Integer.parseInt(s[3]);// y좌표
		int k = Integer.parseInt(s[4]);// 명령개수
		map = new int[n][m];
		StringTokenizer st;
		// map입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// 움직이는 방향 입력
		int[] dice = new int[7];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < k; i++) {
			int d = Integer.parseInt(st.nextToken());
			int nx = x + dx[d - 1];
			int ny = y + dy[d - 1];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				dice = dicemove(d, dice);
				// 이동한 칸 0이면 바닥칸->이동한칸
				if (map[nx][ny] == 0) {
					map[nx][ny] = dice[6];
				} else {
					dice[6] = map[nx][ny];
					map[nx][ny] = 0;
				}
				System.out.println(dice[3]);// 윗면 출력
				x = nx;
				y = ny;
			}

			in.close();
		}
	}

	static int[] dicemove(int d, int[] dice) {
		int temp[] = new int[7];//이동한 주사위 저장
		//전개도에 따라 번호 2->1 4->2 1->3 3->4 5->5 6->6
		// 동쪽
		if (d == 1) {
			temp[6] = dice[4];
			temp[2] = dice[6];
			temp[4] = dice[3];
			temp[3] = dice[2];
			temp[5] = dice[5];
			temp[1] = dice[1];
		}
		// 서쪽
		else if (d == 2) {
			temp[4] = dice[6];
			temp[6] = dice[2];
			temp[3] = dice[4];
			temp[2] = dice[3];
			temp[5] = dice[5];
			temp[1] = dice[1];
		}
		// 북쪽
		else if (d == 3) {
			temp[3] = dice[1];
			temp[5] = dice[3];
			temp[6] = dice[5];
			temp[1] = dice[6];
			temp[2] = dice[2];
			temp[4] = dice[4];
		}
		// 남쪽
		else {
			temp[1] = dice[3];
			temp[3] = dice[5];
			temp[5] = dice[6];
			temp[6] = dice[1];
			temp[2] = dice[2];
			temp[4] = dice[4];
		}
		return temp;
	}
}
