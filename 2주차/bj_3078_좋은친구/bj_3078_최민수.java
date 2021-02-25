package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//[골드 3] 좋은 친구
//https://www.acmicpc.net/problem/3078
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_3078_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_3078_input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//학생 수 N명( 3~300,000), 등수차 K(1~N)
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//이름길이, 0 = 등수
//		int[][] arr = new int[20][N];
		ArrayList<Integer> arr[] = new ArrayList[]<Integer>();
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N; i++) {
			//arr[이름길이][i] = 전체 등수(0등~N-1등)
			System.out.println(i);
//			System.out.println(br.readLine().length());
			arr[br.readLine().length()].add(i);
		}
		
		//정답
		int answer = 0;
		
		//짝 조회
		//이름 길이가 1인 것 중에 짝이 있나?
		//2, 3, 4, ...
		//arr[i][j]가
		for (int i = 0; i < 20; i++) {
			if(arr[i].isEmpty()) continue;
			for (int j = 0; j < arr[i].size(); j++) {
				for (int k = j+1; k < arr[i].size(); k++) {
					if(arr[i].get(j) - arr[i].get(k) <= K) answer++;
					else break;
				}
				//arr[i].get(j);
				//j번째 원소랑 짝이 몇개니
				//j+1번째 원소랑 짝이 몇개니
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(answer+"\n");
		bw.flush();
		bw.close();
//		System.out.println(answer);

		br.close();
	}
}