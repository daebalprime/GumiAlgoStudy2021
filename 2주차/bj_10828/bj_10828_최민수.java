package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//[실버 4] 스택
//https://www.acmicpc.net/problem/10828
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_10828_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_10828_input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> ls = new LinkedList<Integer>();
		String line = null;
		String[] option = new String[2];
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			line = br.readLine();
			option = line.split(" ");
			switch(option[0]) {
			case "push":
				ls.add(Integer.parseInt(option[1]));
				break; 
			case "pop":
				if(ls.size() == 0) {
					System.out.println("-1");
					break;
				}
				System.out.println(ls.get(ls.size()-1));
				ls.remove(ls.size()-1);
				break; 
			case "size":
				System.out.println(ls.size());
				break; 
			case "empty":
				if(ls.isEmpty() == true) {
					System.out.println("1");
					break;
				}else {
					System.out.println("0");
					break;
				}
				
			case "top":
				if(ls.size() == 0) {
					System.out.println("-1");
					break;
				}
				System.out.println(ls.get(ls.size()-1));
				break; 
			}
		}
	}
}

//시도 1. ArrayList + switch문 = 시간초과
//시도 2. LinkedList + switch문 = 시간초과
//시도 3. Scanner에서 BufferedReader로 교체
