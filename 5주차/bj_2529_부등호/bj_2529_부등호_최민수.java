package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[실버 2] 부등호
//https://www.acmicpc.net/problem/2529
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2529_부등호_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2529"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//부등호 문자의 개수 k 2~9
		int k = Integer.parseInt(br.readLine());
		char[] inequal = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < inequal.length; i++) {
			inequal[i] = st.nextToken().charAt(0);
		}
		
		//핵심 아이디어
		//모든 경우의 수(순열)을 구해서 돌리면서 최대, 최소 찾을 것이다.
		
		
		//최소값을 구할 순열 배열
		//최소값이니까 0부터 넣어줌
		int[] perm = new int[k+1];
		for (int i = 0; i < k+1; i++) {
			perm[i] = i;
		}
		//최대값을 넣을 순열 배열
		//최대값이니까 9부터 역으로 넣어줌
		int[] largePerm = new int[k+1];
		for (int i = 0; i < largePerm.length; i++) {
			largePerm[i] = 9-i;
		}
		//넣고다서 nextPerm 돌릴꺼니까 정렬
		Arrays.sort(largePerm);
		
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;

		//789 상태도 확인해야되니까 do-while로 돌림
		do {
			check(largePerm, inequal);
		} while (nextPerm(largePerm));

		//0이 누락되는 경우가 있어서 그 대책
		//legnth: max의 길이
		int length = (int)(Math.log10(max)+1);
		StringBuilder sb = new StringBuilder();
		//길이가 최대 길이보다 작으면 맨 앞에 0이 누락됐다는 것
		if(length < k+1) sb.append("0");
		sb.append(max);
		System.out.println(sb);

		//최소값 구하기. 위의 최대값 구하기와 동일
		do {
			check(perm, inequal);
		} while (nextPerm(perm));

		int length2 = (int)(Math.log10(min)+1);
		StringBuilder sb2 = new StringBuilder();
		if(length2 < k+1) sb2.append("0");
		sb2.append(min);
		System.out.println(sb2);
		
		br.close();
	}

	static long max, min;
	private static void check(int[] perm, char[] ine) {
		// 부등호 조건 체크
		// 중간에 걸리면 return
		for (int i = 0; i < ine.length; i++) {
			if(ine[i] == '<') {
				if(perm[i] > perm[i+1]) return;
			}else {
				if(perm[i] < perm[i+1]) return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < perm.length; i++) {
			sb.append(perm[i]);
		}
		
		//값이 터져서 long으로 처리함
		long temp = Long.parseLong(sb.toString());
		//안걸리면 max, min값 저장하기
		min = Math.min(min, temp);
		max = Math.max(max, temp);
		
	}

	//익히 아는 넥퍼
	private static boolean nextPerm(int[] perm) {
		int i = perm.length-1;
		while(i>0 && perm[i-1] >= perm[i]) i--;
		
		if(i == 0) return false;
		
		int j = perm.length-1;
		while(perm[i-1] >= perm[j]) j--;
		swap(perm, i-1, j);
		
		int k = perm.length-1;
		while(k > i) swap(perm, i++, k--);
		return true;
	}

	private static void swap(int[] perm, int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
		
	}
}
