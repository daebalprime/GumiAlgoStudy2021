package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//[실버 4] 큐 2
//https://www.acmicpc.net/problem/18258
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_18258_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_18258_input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> al = new ArrayDeque<Integer>();
		int T = Integer.parseInt(br.readLine());
		String[] order = null;
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < T; i++) {
			order = br.readLine().split(" ");
			if(order[0].equals("push")) {
				al.add(Integer.parseInt(order[1]));
			}else if(order[0].equals("pop")) {
				if(al.size() == 0) {
					sb.append(-1+"\n");
				}
				else{
					sb.append(al.removeFirst()+"\n");
				}
			}else if(order[0].equals("size")) {
				sb.append(al.size()+"\n");
			}else if(order[0].equals("empty")) {
				if(al.isEmpty() == true) {
					sb.append(1+"\n");
				}
				else{
					sb.append(0+"\n");
				}
			}else if(order[0].equals("front")) {
				if(al.size() == 0) {
					sb.append(-1+"\n");
				}
				else{
					sb.append(al.getFirst()+"\n");
				}
			}else if(order[0].equals("back")) {
				if(al.size() == 0) {
					sb.append(-1+"\n");
				}
				else{
					sb.append(al.getLast()+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
//빠르게 하려고 쓴 것: 그냥출력 -> StringBuffer
//switch -> if else
//tokenizer -> split
//ArrayList -> Deque