package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//[실버 3] 프린터 큐
//https://www.acmicpc.net/problem/1966
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1966_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_1966_input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Testcase만큼 반복. 
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			//문서의 개수:N = 1~100, 궁금한 문서 M = 0~N
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int docNum = Integer.parseInt(st.nextToken());
			int whichDoc = Integer.parseInt(st.nextToken());
			int answer = 0;
			//문서의 중요도 배열 중요도 1~9. 중복가능.
			List<Integer> doc = new ArrayList<Integer>(docNum);
			doc.clear();
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int size = st2.countTokens();
			for (int j = 0; j < size; j++) {
				doc.add(Integer.parseInt(st2.nextToken()));
			}
			
			//목표 문서 출력할 때까지 돈다.
			while(true) {
				//0번째보다 큰지 확인. 큰거 있으면 다 넘겼다.
				for (int k = 1; k < doc.size(); k++) {
					//0번쨰원소보다 뒤에있는 누군가가 크다
					if(doc.get(0) < doc.get(k)) {
						//그러면 0번쨰 원소를 마지막으로 옮긴다.
						int temp = doc.get(0);
						//제거하기전에 먼저 whichDoc을 옮기고
						if(whichDoc == 0) whichDoc = doc.size()-1;
						else whichDoc--;
						doc.remove(0);
						doc.add(temp);
						k = 0;
						continue;
					}
				}
				
				//큰거 다넘겼으니까 이제는
				//뒤에있는 누군가보다 다 크다.
				
				//만약 이번에 출력할게 목표 문서다.
				if(whichDoc == 0) {
					++answer;
					break;
				}
				//출력문서가 아니면
				doc.remove(0);
				whichDoc--;
				answer++;
			}
			System.out.println(answer);
		}
		br.close();
	}
}

// <의식의 흐름>
// 1. 나보다 높은 숫자는 무조건 나보다 먼저 나간다
// 2. 나보다 낮은 숫자는 무조건 나보다 늦게 나간다.
// 3. 같으면 위치따라 나간다? 아니다. ㄴㄴㄴㄴ
// 규칙 못찾겠다  하드코딩 ㄱ

//​하드 코딩으로 짰다.
//목표 문서를 출력할 때까지 while로 무한 루프
//0번쨰 원소보다 뒤에 있는 원소가 하나라도 크면 0번쨰 원소를 맨뒤로 옮기고, 다시 검사
//0번쨰 원소가 이제 제일 크면 출력. 그런데 그게 목표 문서이면 끝. 목표문서가 아니면 다시 검사.
//그리고 출력할 때마다 answer++