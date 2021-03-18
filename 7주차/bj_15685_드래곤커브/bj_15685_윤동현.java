import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {

	static ArrayList<Integer> generation= new ArrayList<>();
	static boolean[][] map = new boolean[101][101];
	static int dx[] = {1,0,-1,0};
    static int dy[] = {0,-1,0,1};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			dragonCurve(x, y, d, g);
		}

		System.out.println(squareCheck());
		
		br.close();
	}
	//0세대 방향 : 0
	//1세대 방향 : 0 1
	//2세대 방향 : 0 1 2 1
	//3세대 방향 : 0 1 2 1 2 3 2 1
	// 그전 세대의 역순으로 +1, 세대 증가시 *2씩 사이즈 증가

	static void generationCreate(int d, int g) {
		generation.add(d); // 0세대 생성완료
	
		for(int i=0; i<g; i++) {
			//각 세대별로 그전 세대의 역순으로 찍힘으로 0부터 시작이 아닌 마지막에서부터 시작
			for(int j=generation.size()-1; j>=0; j--) {
				generation.add((generation.get(j)+1)%4); //그 전 세대의 역순으로 해당하는 값으 +1이므로 3+1은 90도 회전시 0이랑 같으므로 0~3인덱스를 항상 유지
			}
		}
	}

	static void dragonCurve(int x, int y, int d, int g) {
		generationCreate(d, g);

		map[y][x] = true;
		for(int dir: generation) {
			x += dx[dir];
			y += dy[dir];
			map[y][x] = true;
		}

		generation.clear();
	}

	static int squareCheck() {
		int cnt = 0;
		//(i,j) (i+1,j) (i,j+1) (i+1,j+1)체크하므로 101이 아니라 100까지만 실행해도 됨
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) cnt++;
			}
		}
		return cnt;
	}
}