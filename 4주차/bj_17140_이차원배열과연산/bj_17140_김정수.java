package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b17140 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[100][100];
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rowLen = 3;
		int colLen = 3;
		
		int time = 0;
		
		do {
			if(arr[r-1][c-1] == k) {
				break;
			}
			// R, C 크기 비교
			int oper = rowLen>=colLen? 0: 1; // 0이면 R연산, 1이면 C연산
			
			// R연산
			if(oper == 0) {
				int maxColLen = 0;
				// row별로 정렬 수행
				for(int i=0;i<rowLen;i++) {
					Map<Integer, Integer> count = new HashMap<>();
					// count map에 등장 수 저장
					for(int j=0;j<colLen;j++) {
						if(arr[i][j] == 0) continue; // 한계 도달할 경우 저장 종료
						if(count.containsKey(arr[i][j])) {
							count.replace(arr[i][j], count.get(arr[i][j])+1);
						}
						else {
							count.put(arr[i][j], 1);
						}
					}
					
					// map을 등장 순으로 오름차순 정렬
					Object[] mapkey = count.keySet().toArray();
					Arrays.sort(mapkey, (o1, o2)->{
						return count.get(o1) == count.get(o2) ? (Integer)o1-(Integer)o2  : count.get(o1) - count.get(o2);
					});
					
					// 새로운 배열에 수, 등장횟수 순으로 새로 저장하기
					for(int j=0;j<(mapkey.length*2)%100;j+=2) {
						arr[i][j] = (Integer)mapkey[j/2];
						arr[i][j+1] = count.get((Integer)mapkey[j/2]);
					}
					
					// 범위에 안드간거 0으로 초기화
					for(int j=99;j>=(mapkey.length*2)%100;j--) {
						arr[i][j] = 0;
					}
					
					// R 연산이 적용된 경우에는 가장 큰 행을 기준으로 모든 행의 크기가 변한다.
					maxColLen = Math.max(maxColLen, (mapkey.length*2)%100);
				}
				colLen = maxColLen;
			}
			else {
				// C연산
				int maxRowLen = 0;
				//col별로 정렬 수행
				for(int i=0;i<colLen;i++) {
					Map<Integer, Integer> count = new HashMap<>();
					// count map에 등장 수 저장
					for(int j=0;j<rowLen;j++) {
						if(arr[j][i] == 0) continue; // 한계 도달할 경우 저장 종료
						if(count.containsKey(arr[j][i])) {
							count.replace(arr[j][i], count.get(arr[j][i])+1);
						}
						else {
							count.put(arr[j][i], 1);
						}
					}
					
					// map을 등장 순으로 오름차순 정렬
					Object[] mapkey = count.keySet().toArray();
					Arrays.sort(mapkey, (o1, o2)->{
						return count.get(o1) == count.get(o2) ? (Integer)o1-(Integer)o2  : count.get(o1) - count.get(o2);
					});
					
					// 새로운 배열에 수, 등장횟수 순으로 새로 저장하기
					for(int j=0;j<(mapkey.length*2)%100;j+=2) {
						arr[j][i] = (Integer)mapkey[j/2];
						arr[j+1][i] = count.get((Integer)mapkey[j/2]);
					}
					
					// 범위에 안드간거 0으로 초기화
					for(int j=99;j>=(mapkey.length*2)%100;j--) {
						arr[j][i] = 0;
					}
					
					// R 연산이 적용된 경우에는 가장 큰 행을 기준으로 모든 행의 크기가 변한다.
					maxRowLen = Math.max(maxRowLen, (mapkey.length*2)%100);
				}
				rowLen = maxRowLen;
			}
			/*
			System.out.println(time);
			
			for(int i=0;i<rowLen;i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println(rowLen +" "+colLen);
*/
			if(arr[r-1][c-1] == k) {
				time++;
				break;
			}
			
		}while(++time<=100);
		
		if(time > 100) time = -1;
		System.out.println(time);
	}

}
