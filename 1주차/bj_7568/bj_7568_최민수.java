package baekjoon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//[실버 5] 덩치
//https://www.acmicpc.net/problem/7568
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_7568_최민수 {

	
	public static void main(String[] args) throws Exception {
		//테스트 입력
		//System.setIn(new FileInputStream("res/baekjoon/bj_7568_input"));
		Scanner scan = new Scanner(System.in);
		//먼저 몸무게로 소팅한다음
		//키를 바교해볼까?
		int N = scan.nextInt();
		//[][0]에는 몸무게 [][1]에는 키를 저장할까?
		//저장을 MAP을 써볼까?
		int[][] spec = new int[N][3];
		for (int i = 0; i < N; i++) {
			spec[i][0] = scan.nextInt();
			spec[i][1] = scan.nextInt();
		}
		//체크용 01
//		for (int[] it: spec) {
//			System.out.println(Arrays.toString(it));
//		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//i의 몸무게가 더 크고 && 키도 더크면
				//i가 j보다 덩치가 크다.
				if(spec[i][0] < spec[j][0] && spec[i][1] < spec[j][1]) {
					spec[i][2]++;
				}
			}
		}
//		Arrays.sort(spec, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(spec[i][2]+1);
		}
		
		scan.close();
		
	}
}
