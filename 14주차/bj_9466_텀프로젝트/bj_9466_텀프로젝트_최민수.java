package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//[골드 3] 텀 프로젝트
//https://www.acmicpc.net/problem/9466
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_9466_텀프로젝트_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_9466"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 괴상한 코드임. 이해하기 힘들 것. 문의는 최민수에게@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			//전역변수 초기화
			answer = 0;
			//입력
			//학생 수 n 2~10만
			int n = Integer.parseInt(br.readLine());
			
			//팀이 되는 조건
			//1. 자기가 자기를 찍거나
			//2. x명의 사람들 사이에 사이클이 발생하거나.
			
			//다른 아이디어. 그냥 연결리스트처럼 쭉 따라가서 자기가 나오면 팀원이다.
			//그런데 탐색하다가 이미 팀으로 속한 사람을 만나면 탐색을 중지하고 불합격자로 처리한다.
			int[][] arr = new int[n+1][2]; //0: 실제 값, 1: 방문 여부. 0이면 미판정, 1이면 방문했음
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				//자기 자신에게 도달하는 친구들은 미리 표시해보자
				if(arr[i][0] == i) arr[i][1] = 1;
			}
			for (int i = 1; i <= n; i++) {
				if(arr[i][1] == 0) {//미판정이면
					//팀이 될 수 있는지 없는지 판정
					//yes가 true이면 팀이 될 수 있다.
					//yes가 false이면 팀이 될 수 없다.
					boolean yes = false;
					int start = i;
					int end = i;
					
					//탐색하면서 깊이를 카운팅하고
					ArrayDeque<Integer> d = new ArrayDeque<Integer>();
					int depth = 0;
					while(true) {
						if(arr[start][1] != 0) break;
						//자기자리 마킹
						arr[start][1] = 1;
						d.offer(start);
						
						//도착값이 end값과 같으면 순환이다. 끝.
						if(arr[start][0] == end) {
							yes = true;
							break;
						}else if(arr[start][0] == start){ //자기 자신을 향했다.
							yes = false;
							break;
						} else {
							depth++;
							start = arr[start][0];
						}
					}
					//순환이면 무시하고, 비순환이면 answer에 깊이를 더해준다.
					if(!yes) {
						//순환고리를 제외하고 더해줄 수 있을까?
						//방문 후보지를 큐에 넣고
						//마지막 도착지가 나올때까지 큐에서 빼고
						//큐 크기만큼 depth에서 뺀다.
						while(true) {
							if(d.isEmpty()) break; //null pointer exception.
							if(d.peek() == start) {
								depth -= d.size();
								break;
							}
							d.poll();
						}
						
						answer += depth;
					}
				}
			}
			//출력
			System.out.println(answer);
		}
		
		br.close();
	}
	
	static int answer;

}
//폐기 아이디어. 유니온 파인드?
