package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//[골드 5] 배
//https://www.acmicpc.net/problem/1092
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1092_배_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1092"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//아이디어 각 박스가 입력으로 들어올때마다
		//알맞은 크레인에 할당한다.
		//가장 무거운 크레인보다 높으면 바로 -1
		//다 할당한 후엔 업무 분배
		//업무 분배는 가장 무거운걸 들 수 있는 크레인부터 박스를 1개씩 가져가는 것.
		
		//크레인 N대 1~50
		int n = Integer.parseInt(br.readLine());
		int crane[][] = new int[n][2];
		//[0] 감당가능 무게, [1]할당박스
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < crane.length; i++) {
			crane[i][0] = Integer.parseInt(st.nextToken());			
		}
		//크레인 감당가능 무게 순으로 정렬
		Arrays.sort(crane, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}

		});
		
		
		//박스 M개 1~10000
		int m = Integer.parseInt(br.readLine());
		int box[] = new int[m];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < box.length; i++) {
			box[i] = Integer.parseInt(st2.nextToken());
			
			//자신이 감당 가능한 무게의 박스를 저장
			for (int j = 0; j < crane.length; j++) {
				if(box[i] <= crane[j][0]) {
					crane[j][1]++;
					break;
					//마지막 크레인보다 더 박스가 무거우면 끝
				}else if(j == crane.length -1) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
//		for(int[] in : crane)System.out.println(Arrays.toString(in));
//		System.out.println();
		
		int answer = 0;
		while(true) {
			//남은 가장 위에서부터
			int endCount = 0;
			for (int i = crane.length-1; i >= 0 ; i--) {
				//지금 크레인에 할당된 박스를 다 처리했으면
				if(crane[i][1] == 0) {
					//자기보다 가벼운 크레인찾아가서 일 대신 처리하기
					for (int j = i-1; j >= 0; j--) {
						if(crane[j][1] > 0) {
							crane[j][1]--;
							break;
						}
					}
					endCount++;
				}else { // 크레인 자신에게 할당된 일감이 있으면 일하기
					crane[i][1]--;
					if(crane[i][1]==0) endCount++;
				}
			}
//			for(int[] in : crane)System.out.println(Arrays.toString(in));
//			System.out.println();
			answer++;
			if(endCount == crane.length) {
				System.out.println(answer);
				break;
			}
		}
		
		br.close();
	}
}
