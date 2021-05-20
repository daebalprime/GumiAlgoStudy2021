package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[실버 1] 회문
//https://www.acmicpc.net/problem/17609
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_17609_회문_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_17609"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//아이디어1. 글자수를 샌다.
		//경우는 0, 1, 2 3가지인데
		//회문인 경우엔 대칭만 확인하면 된다. => 괄호처럼 스택으로 하면 될듯
		//회문이 아닌 경우에는 괄호처럼 스택으로 하면 처리가능하다.
		//문제는 유사회문인 경우인데
		
		//양끝에서 조회를 하다가. 일치하지 않는다면, 왼쪽을 1칸 땡겨보거나, 오른쪽을 한칸 땡겨서 일치하면 계속 조회하자.
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			char[] charList = br.readLine().toCharArray();
			
			int leftIndex = 0;
			int rightIndex = charList.length - 1;
			int leftChance = 1;
			
			int leftAnswer = 0;
			int rightAnswer = 0;
			
			//왼쪽만 당기는 팰린드롬
			while(true) {
				//왼쪽, 오른쪽 인덱스가 같거나, 왼쪽보다 오른쪽이 더 작으면 끝
				if(leftIndex >= rightIndex) {
					if(leftChance == 0) leftAnswer = 1;
					else leftAnswer = 0;
					break;
				}
				
				//왼오가 같은지 확인
				if(charList[leftIndex] == charList[rightIndex]) {
					//같으면 다음 인덱스로 넘어가면 됨
					leftIndex++;
					rightIndex--;
				}else {
					//다르다. 여기선 왼쪽만 당길 수 있다.
					//그런데 남은 기회가 없으면 끝
					if(leftChance == 0) {
						leftAnswer = 2;
						break;
					}else if(charList[leftIndex+1] == charList[rightIndex]) {
						//같으면 찬스 한번 빼고
						leftChance = 0;
						leftIndex += 2;
						rightIndex --;
					}else {
						leftAnswer = 2;
						break;
					}
				}				
			}
			//오른쪽만 당기는 팰린드롬
			leftIndex = 0;
			rightIndex = charList.length - 1;
			leftChance = 1;
			while(true) {
				//왼쪽, 오른쪽 인덱스가 같거나, 왼쪽보다 오른쪽이 더 작으면 끝
				if(leftIndex >= rightIndex) {
					if(leftChance == 0) rightAnswer = 1;
					else rightAnswer = 0;
					break;
				}
				
				//왼오가 같은지 확인
				if(charList[leftIndex] == charList[rightIndex]) {
					//같으면 다음 인덱스로 넘어가면 됨
					leftIndex++;
					rightIndex--;
				}else {
					//그런데 남은 기회가 없으면 끝
					if(leftChance == 0) {
						rightAnswer = 2;
						break;
					}else if(charList[leftIndex] == charList[rightIndex-1]) {
						//같으면 찬스 한번 빼고
						leftChance = 0;
						leftIndex++;
						rightIndex -= 2;
					}else {
						rightAnswer = 2;
						break;
					}
				}				
			}
			int answer = leftAnswer <= rightAnswer ? leftAnswer : rightAnswer ;
			System.out.println(answer);
		}
	
		br.close();
	}
}
