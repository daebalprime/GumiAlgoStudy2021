package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[브론즈2] 시험 감독
//https://www.acmicpc.net/problem/13458
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_13458_시험감독_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_13458"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//시험장의 수 N 1~100만
		int N = Integer.parseInt(br.readLine());
		//각 시험장에 있는 응시자의 수 1~100만
		int clas[] = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			clas[i] = Integer.parseInt(st1.nextToken());
		}
		//감시할 수 있는 응시자의 수: 총 감독관 B 1~, 부 감독관 ~100만
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());
		
		long answer = N;
		for (int i = 0; i < N; i++) {
			//각 교실에서 총 감독관이 감당 가능한 B를 빼고
			//그래도 양수이면 C를 나눠서 구한다.
			if(clas[i] - B > 0) {
				if((clas[i]-B)%C > 0) answer++;
				answer += (clas[i] - B)/C;
			}
		}
		
		System.out.println(answer);
		
		br.close();
	}
}
