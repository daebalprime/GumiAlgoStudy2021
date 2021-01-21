import java.io.FileInputStream;
import java.util.Scanner;

//[실버5] 그룹 단어 체커
//https://www.acmicpc.net/problem/1316
//제출전에 Main으로 바꾸기, file input 지우기, pacakge 지우기
public class Main {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		//System.setIn(new FileInputStream("res/baekjoon/bj_1316_input"));

		Scanner scan = new Scanner(System.in);
		// 단어의 개수 N
		int N = Integer.parseInt(scan.nextLine());
		int result = 0;
		int isState = 0; //0이면 시작, 1이면 j랑 k가 처음 다를때, 2이면 1인상태에서 같을때

		for (int i = 0; i < N; i++) {
			//단어 받고
			String word = scan.nextLine();
			//한글자짜리 단어면 for문 skip
			if(word.length() == 1) {
				result++;
				continue;
			}
			
			//그룹 단어인지 확인
			//방법1. 첫번째 알파벳이 중복된게 있는지 확인
			Loop: for(int j=0; j<word.length(); j++) {
				for(int k=j+1; k<word.length(); k++) {
					// 같다, 다르다, 같다 X
					// 같다, 같다, 같다, O
					// 다르다, 다르다, 다르다 O
					// 같다, 다르다, 다르다 O
					// 즉 한 번 달랐다(1)가 같으면(2) 그룹단어가 아니다.
					//0->1: 계속 같다가 달라졌나?
					if(isState == 0 && (word.charAt(j) != word.charAt(k))) isState = 1;
					// 1인상태에서 같은지? 2체크
					if(isState == 1 && (word.charAt(j) == word.charAt(k))) {
						result--;
						isState = 0;
						break Loop;
					}
				}
				//loop한번 돌고 0(시작)으로 초기화
				isState = 0;
			}
			result++;
		}
		System.out.println(result);
		scan.close();
	}
}
