package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//@@@서브테스트2 못맞춤. 100/140점 코드@@@@@@@@@@@@@@@@@@@@@

//[실버 1] 세훈이의 선물가게
//https://www.acmicpc.net/problem/17225
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_17225_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_17225_input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbS = new StringBuilder();
		StringBuilder sbJ = new StringBuilder();

		List<Integer> presentS = new ArrayList<Integer>();
		List<Integer> presentJ = new ArrayList<Integer>();

		//마지막 포장시간을 저장해놔야 다음 주문 처리가능
		int lastOrderS = 0;
		int lastOrderJ = 0;
		//A. 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//상민이의 포장시간
		int sangT = Integer.parseInt(st.nextToken());
		//지수의 포장시간
		int jiT = Integer.parseInt(st.nextToken());
		//상민이 포장한 총 선물
		int answerS = 0;
		//지수가 포장한 총 선물
		int answerJ = 0;
		//총 손님 수
		int customNum = Integer.parseInt(st.nextToken());
		for (int i = 0; i < customNum; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			//주문 시각
			int startTime = Integer.parseInt(st2.nextToken());
			//포장지 색
			String color = st2.nextToken();
			//주문한 선물의 개수
			int preNum = Integer.parseInt(st2.nextToken());
			
			//B. 계산 과정
			//손님들의 입력이 들어오면
			//각 선물의 포장시간을 계산해 각자의 ArrayList에 처리 시간을 넣음.
			//선물 개수만큼 반복
			//추후에 두 사람의 List를 차례대로 꺼내면서 시간 비교하면서 선물 순서를 기록할 것임.
			for (int j = 0; j < preNum; j++) {
				if(color.equals("B")) { //상민이 주문
					//마지막 주문시간이 주문보다 길면
					if(startTime < lastOrderS) startTime = lastOrderS;
					//하루를 넘기면
					if(startTime+j*sangT > 86400) continue;
					presentS.add(startTime+j*sangT);
					answerS++;
					//마지막 포장시간을 저장해놔야 다음 주문 처리가능
					if(j == preNum-1) lastOrderS = startTime+j*sangT;
				}else { //지수 주문
					//마지막 주문시간이 주문보다 길면
					if(startTime < lastOrderJ) startTime = lastOrderJ;
					//하루를 넘기면
					if(startTime+j*sangT > 86400) continue;
					presentJ.add(startTime+j*jiT);
					answerJ++;
					//마지막 포장시간을 저장해놔야 다음 주문 처리가능
					if(j == preNum-1) lastOrderJ = startTime+j*jiT;
				}
			}
		}
		//선물 다 넣었다. 일단 시간 순으로 정렬해보자.		
		Collections.sort(presentS);
		Collections.sort(presentJ);


		
		//시간을 순서로 처리하기
		int x=0, y=0;
		for (int i = 0; i < presentS.size()+presentJ.size(); i++) {
			//범위 밖
			if(x>=presentS.size()) {
				while(i < presentS.size()+presentJ.size()) {
					sbJ.append(i+1).append(" ");
					i++;
					y++;
				}
				break;
			}else if(y >= presentJ.size()) {
				while(i < presentS.size()+presentJ.size()) {
					sbS.append(i+1).append(" ");
					i++;
					x++;
				}
				break;
			}
			//시간이 겹칠때
			if(presentS.get(x) == presentJ.get(y)) {
				sbS.append(i+1).append(" ");
				sbJ.append(i+2).append(" ");
				x++;
				y++;
				i++;
			}else if(presentS.get(x) < presentJ.get(y)) { //시간이 안겹칠때
				x++;
				sbS.append(i+1).append(" ");
			}else {
				sbJ.append(i+1).append(" ");
				y++;
			}
		}
		
		//C. 출력
		//1. 상민이가 포장한 선물의 수
		System.out.println(answerS);
		//2. 상민이가 포장한 선물들의 번호 오름차순
		sbS.setLength(sbS.length()-1);
		System.out.println(sbS);
		//3. 지수 선물 수
		System.out.println(answerJ);
		// 4. 지수가 포장한 선물 번호 오름차순
		sbJ.setLength(sbJ.length()-1);
		System.out.println(sbJ);
		
		br.close();
	}
}