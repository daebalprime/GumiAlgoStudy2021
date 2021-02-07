package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//[실버 2] 외계인의 기타 연주
//https://www.acmicpc.net/problem/2841
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2841_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_2841_input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = new String[2];
		List<Integer>[] al = new ArrayList[6];
		//초기화? 용어가 정확히 뭔지 햇갈림
		for (int i = 0; i <6; i++) {
			al[i] = new ArrayList<Integer>();
		}
		
		input = br.readLine().split(" ");
		int p = Integer.parseInt(input[0]); 
		int answer = 0;
		int line = 0;
		int fret = 0;
		//00. 몇번째 줄인지 부터 확인.
		//01. 값을 받아서 스택 가장 위의 원소와 비교
		Loop: for (int i = 0; i < p; i++) {
			input = br.readLine().split(" ");
			line = Integer.parseInt(input[0])-1;
			
			fret = Integer.parseInt(input[1]);
			if(al[line].size() == 0) {
				al[line].add(fret);
				answer++;
			}
			else {
				//02. 값이 더크면 그대로 넣는다.
				if(fret > al[line].get(al[line].size()-1)) { 
					al[line].add(fret);
					answer++;
				}else if(fret == al[line].get(al[line].size()-1)) {
					//03. 값이 같으면 아무것도 안한다.
				}else { //04. 값이 작으면 같거나 커질때까지 뺀다.
					while(fret < al[line].get(al[line].size()-1)) {
						al[line].remove(al[line].size()-1);
						answer++;
						//04-1 스택에 뺄게 없으면 종료
						if(al[line].size() == 0) {
							break;
						}
						//04-2. 남은 한개랑 현재 값이랑 같으면 03case니까 탈출
						if(fret == al[line].get(al[line].size()-1)) continue Loop;
					}
					//04. 스택이 비었거나, 내가 스택 맨위값보다 커졌으니까 추가.
					al[line].add(fret);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}

/*
기타의 구성: 6개의 줄 + 각 줄마다 P개의 프랫
어떤 줄의 프렛을 여러 개 누르고 있다면, 가장 높은 프렛의 음이 발생
1 3 5가 있으면 5가 연주됨. 1연주하고 싶으면 3, 5떄야됨.
손가락으로 프렛을 한 번 누르거나 떼는 것을 손가락을 한 번 움직였다
손가락의 가장 적게 움직이는 회수를 구하는 프로그램을 작성

이게 각 기타줄마다 발생
*/