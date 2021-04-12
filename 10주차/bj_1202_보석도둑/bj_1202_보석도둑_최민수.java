package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//참고: https://dundung.tistory.com/88

//[골드 2] 보석 도둑
//https://www.acmicpc.net/problem/1202
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1202_보석도둑_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1202"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//n 1~30만, k: 1~30만
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] jewel = new int[n][2]; //[0]: 무게, [1]: 가치 
//		PriorityQueue<jewel> jpq = new PriorityQueue<jewel>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewel[i][0] = weight;
			jewel[i][1] = price;
//			jpq.offer(new jewel(weight, price));
		}

		Arrays.sort(jewel, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]); //무게 오름차순 
			}
		});
		
		int[][] bag = new int[k][2]; //[0]: 무게, [1]: 가방 사용 여부(0: 미사용, 1: 사용)
		for (int i = 0; i < k; i++) {
			bag[i][0] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		long answer = 0;
		//greedy
		
		Queue<jewelry> pq = new PriorityQueue<jewelry>();
		int j = 0;
		//이렇게 하면 O(N+K)인데 왜 이게 동작하는지는 아직도 정확하게는 이해가 안됐음.
		for (int i = 0; i < k; i++) {
			while(j < n && jewel[j][0] <= bag[i][0]) { //가방 무게보다 보석이 가벼우면
				pq.offer(new jewelry(jewel[j][0], jewel[j][1]));
				j++;
			}
			if(!pq.isEmpty()) {
				answer += pq.poll().price;
			}
		}
		
		
//		for (int i = 0; i < n; i++) { //가장 가치 높은 보석부터
//		while(!jpq.isEmpty()) {
//			jewel current = jpq.poll();
//			for (int j = 0; j < k; j++) {
//				if(bag[j][1] != 0) continue; //이미 사용한 가방
//				else if(bag[j][0] >= current.weight) { //보석보다 가방이 무거우면 넣는다
//					bag[j][1] = 1;
//					answer += current.price;
//					break; //다음 보석으로
//				}
//			}
//		}
		System.out.println(answer);
		
		
		br.close();
	}
	
	static class jewelry implements Comparable<jewelry>{
		int weight, price;

		public jewelry(int weight, int price) {
			super();
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(jewelry o) {
			return -Integer.compare(this.price, o.price);
		}
		
		
	}
}
//실패한 전략1: 가장 가치가 높은 보석부터, 가장 무게가 작은 가방부터 탐색해서 넣는다.