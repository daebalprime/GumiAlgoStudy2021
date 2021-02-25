package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//[실버4] 균형잡힌 세상
//https://www.acmicpc.net/problem/4949
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_4949_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_4949_input"));
		//<Char>가 안 됨
		List<Integer> al = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Loop: while (true) {
			char[] ca = br.readLine().toCharArray();
			
			//검사시작할때마다 al를 비워줘야한다.
			al.clear();
			
			// 입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.
			if (ca[0] == '.' && ca.length == 1) {
				break;
			}
			// (, [만날때마다 arrayList에 집어넣고
			// ), ] 만날때마다 arrayList에서 꺼내는데 짝이 안맞으면 no
			// 다받았는데 arrayList가 남는 경우 no
			// (=1, )=-1, [=2, ]=-2
			// 1 & -1이짝,    2 & -2가짝
			for (int i = 0; i < ca.length; i++) {
				if (ca[i] == '(') {
					al.add(1);
				} else if(ca[i] == '[') {
					al.add(2);
				} else if (ca[i] == ')') {
					//큐가 비어있는데 )들어오면
					if(al.size() == 0) {
						System.out.println("no");
						continue Loop;
					}
					// () 짝맞는경우
					if(al.get(al.size()-1) == 1) {
						al.remove(al.size()-1);
					}else { //꺼냈는데 [)인 경우
						break;
					}
					
				} else if (ca[i] == ']') {
					//큐가 비어있는데 ]들어오면
					if(al.size() == 0) {
						System.out.println("no");
						continue Loop;
					}
					// [] 짝맞는경우
					if(al.get(al.size()-1) == 2) {
						al.remove(al.size()-1);
					}else { //꺼냈는데 (]인 경우
						break;
					}
				}
			}
			//검사다했는데 짝 못맞춘경우 ex) [[(
			if(al.size() > 0) System.out.println("no");
			else System.out.println("yes");

		}
	}
}

/*﻿
0. 이전 입력값에 영향받지 않도록 ArrayList를 초기화한다.
1. ArrayList에 (. [를 입력받을 때마다 넣어준다.
2. ), ]를 입력 받을 때마다 가장 마지막에 받은 원소가 각각 (, [인지 검사하고
서로 짝이 맞으면 ArrayList 마지막 1칸을 비운다.
짝이 안맞으면 break로 검사를 마친다.
3. ArrayList가 0칸일 때 ), ]가 들어오면 바로 break를 한다.
4. 한문장 검사를 마쳤는데 ArrayList에 남아있는게 있다면 이 또한 균형이 맞지 않는 것으로 판단한다.
*/
