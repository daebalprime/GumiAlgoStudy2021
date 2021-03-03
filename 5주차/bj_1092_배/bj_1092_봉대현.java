package a_5weeks;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
3
6 8 9
5
2 5 2 4 7
3
6 8 9
9
1 2 3 4 5 6 7 8 9
 */
public class Main_bj_1092_배 {
	// 그리디??
	// 메모리 초과..?
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(in.readLine()); // 최대 50
		ArrayList<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) 
			crane.add(stoi(st.nextToken()));
		
		int m = stoi(in.readLine()); // 최대 10,000
		ArrayList<Integer> boxs = new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		for (int j = 0; j < m; j++)
			boxs.add(stoi(st.nextToken())); // 최대 1,000,000
		//내림차순
		Collections.sort(crane,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Collections.sort(boxs,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2) {
				return o2.compareTo(o1);
			}
		});

		// logic
		if (crane.get(0) < boxs.get(0))// 모든 박스를 배로 옮기기 x
			System.out.println(-1);
		else {
			// 인덱스를 가지고놀자
			int time = 0;
			while (boxs.size() !=0) {
				int bidx = 0; //박스에서 사라질 인덱스
				int cidx=0; //크레인 인덱스
				// 무게가 무거운 것은 무거운 크레인쪽부터
				while(cidx<n){
					if(bidx==boxs.size())
						break;
					if(boxs.get(bidx)<=crane.get(cidx)) {
						boxs.remove(bidx);
						cidx++;
					}
					else if(boxs.get(bidx)>crane.get(cidx)) {
						bidx++;
					}
				}
				time += 1;
			}
			System.out.println(time);
		}
		in.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
