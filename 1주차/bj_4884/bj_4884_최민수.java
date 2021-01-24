package baekjoon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@실패한 코드@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@실패한 코드@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//[브론즈1] FIFA 월드컵
//https://www.acmicpc.net/problem/4884
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기

public class bj_4884_최민수 {
	static int addSum(int team) {
		team--;
		return team * (team + 1) / 2;
	}

	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_4884_input"));
		Scanner scan = new Scanner(System.in);
		String[] arr = new String[4];
		// 0<A<=T
		// 토너먼트 참가하는 팀의 수가 2의 제곱꼴이 아니면
		// 가까운 2의 제곱으로 진출하는 팀의 수를 추가시켜야 함

		// 단계 0. 입력받기
		while (true) {		
			arr = scan.nextLine().split(" ");
			// G>0 그룹의 수
			int G = Integer.parseInt(arr[0]);
			// T 각 그룹을 구성하는 팀의 수
			int T = Integer.parseInt(arr[1]);
			// A 각 조에서 토너먼트로 진출하는 팀의 수
			int A = Integer.parseInt(arr[2]);
			// D 조별 리그를 거치지 않고 바로 토너먼트로 진출하는 팀의 수
			int D = Integer.parseInt(arr[3]);
			
			//System.out.println(Arrays.toString(arrInt));
			if (G== -1 && T == -1 && A == -1 && D == -1)
				break;

			// 단계 1. 그룹 스테이지에서 발생하는 경기 수 계산(X1)
			// 4팀이 있으면 3+2+1, 3팀이면 2+1, 5팀이면 4+3+2+1
			// 따라서 각 그룹을 구성하는 팀의 수의 T로 계산한다음
			// 그룹의 수 G를 곱하면 된다.
			int x = 0;
			//G*T
			x = addSum(T) * G;

			// 단계 2. 토너먼트 참가 팀 수를 2의 제곱꼴로 만들기(+Y)
			// 추가없이 참가팀 = A * 그룹의 수 G + D
			// 이 값이 2의 제곱수인지 아닌지
			int torn = A * G + D;
			int y=0;
			//비트연산으로 검사
			for (int i = 1; i < Integer.toBinaryString(torn).length(); i++) {
				//char형 --
				if(Integer.toBinaryString(torn).charAt(i) == '1') {
//					System.out.println(Integer.toBinaryString(torn).length());
					y = (1<<Integer.toBinaryString(torn).length()) - torn;
					break;
				}
			}
			
			
			//시간이 매우 오래 걸리는 듯
//			do {
//				two *= 2;
//				if (torn == two) { //4=4? 2의제곱수
//					//y=0;
//					break;
//				}
//				if(torn < two) {
//					y = two - torn;
//					break;
//				}
//			} while (torn >= two);

			// 단계 3.토너먼트 스테이지에서 발생하는 경기 수 계산.(X2)
			//8강이면 7경기, 16강이면 15경기(8+4+2+1)
		    x += torn+y-1;
		    StringBuffer sb = new StringBuffer();
		    sb.append(G).append("*").append(A).append("/").append(T).append("+").append(D).append("=").append(x).append("+").append(y);
			System.out.println(sb);
			
		}
		scan.close();
//		8*2/4+0=63+0
//		8*2/4+1=79+15
	}
}
