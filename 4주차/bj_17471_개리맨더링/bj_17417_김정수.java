package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b17471 {
	static int N;
	static int[] population;
	static ArrayList<Integer>[] area;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		population = new int[N+1];
		
		int populationSum = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) {
			population[i] = Integer.parseInt(st.nextToken());
			populationSum+= population[i];
		}
		
		// 구역별 인접지역 배열로 저장하기
		area = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			area[i] = new ArrayList();
			int t = Integer.parseInt(st.nextToken());
			for(int j=0;j<t;j++) {
				area[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		//bfs로 인접 구역 펼쳐 나가기
		int minVal = Integer.MAX_VALUE;
		
		for(int i = 0; i<= Math.pow(2, N);i++) {
			int a = canMakeArea(i);
			int b = canMakeArea(~i);
			
			if(a+b == populationSum) {
				minVal = Math.min(minVal, Math.abs(a-b));
			}
		}
		
		if(minVal == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(minVal);
		}
	}
	
	public static int canMakeArea(int flag) {
		// flag 0인 곳 한 군데 찍어서 다 탐색해보기
		int start = -1;
		int sum = 0;
		for(int i=1;i<=N;i++) {
			if((flag & 1<<i) != 0) continue;
			else {
				start = i;
				break;
			}
		}
		
		// 모두 다른 선거구가 차지했으면 유효하지 않음
		if(start == -1) {
			//System.out.println("모두 다른 선거구가 차지했으면 유효하지 않음");
			return -1;
		}
		
		int newFlag = flag | 1<<start;
		Queue <int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start});
		sum += population[start];
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			
			// 인접 구역 탐색
			for(int item: area[q[0]]) {
				if((newFlag & (1<<item)) != 0) continue;
				queue.offer(new int[] {item});
				newFlag |= 1<<item;
				sum += population[item];
			}
		}
		
		// flag 결과가 전부 1이 아니면 유효하지 않은걸로
		for(int i=1;i<=N;i++) {
			if((newFlag & 1<<i) != 0) continue;
			else {
				//System.out.println("flag 결과가 전부 1이 아니면 유효하지 않은걸로");
				return -1;
			}
		}
		return sum;
	}

}
