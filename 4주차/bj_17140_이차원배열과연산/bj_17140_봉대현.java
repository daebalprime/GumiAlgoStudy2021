import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 정렬하러면 각각의 수 카운트
 수의 등장 횟수가 커지는 순,수가 커지는 순으로
 정렬된 결과는 다시  배열 A
 R연산 행>=열 가장 큰행 기준 - 모든 행의 크기 바뀜
 C연산 행<열 가장 큰 열 기준 -모든 열의 크기가 바뀜
 수 -> 0은 무시해야 한다.
 */
public class Main_bj_17140_이차원배열과연산 {

	private static int[][] a;
	private static int rmax;
	private static int cmax;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int r = stoi(st.nextToken());
		int c = stoi(st.nextToken());
		int k = stoi(st.nextToken());
		a = new int[101][101];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				a[i][j] = stoi(st.nextToken());
			}
		}
		int time = 0;
		rmax = 3;
		cmax = 3;
		while (true) {

			if (a[r - 1][c - 1] == k)
				break;
			if (time > 100) {
				System.out.println(-1);
				return;
			}
			if (rmax >= cmax) {
				cmax = rcel();
				
			} else {
				rmax = ccel();
				
			}
			//System.out.println();
			time += 1;

		}
		System.out.println(time);
		in.close();
	}

	private static int rcel() {// 행
		int [][]tmp=new int[101][101];
		int max = 0;
		for (int i = 0; i < rmax; i++) {// 모든 행 정렬
			ArrayList<int[]> p = new ArrayList<>();
			int[] nums = countValue(a[i]);
			boolean check[] = new boolean[101]; // 중복체크 최대가 101번
			for (int j = 0; j < cmax; j++) {
				if (!check[a[i][j]] && a[i][j] != 0) {
					int temp[] = new int[] { a[i][j], nums[a[i][j]] };
					// System.out.println(p.contains(temp));
					p.add(temp);
					check[a[i][j]] = true;
				}
			}
			// 정렬
			p.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int a = o1[1] - o2[1];
					if (a == 0)
						return o1[0] - o2[0];
					return a;
				}
			});
			// 정렬된 결과 저장,행의 최대 저장
			int cnt = 0;

			for (int j = 0; j < p.size(); j++) {
				tmp[i][cnt++] = p.get(j)[0];
				tmp[i][cnt++] = p.get(j)[1];
				max = Math.max(cnt, max);
			}

		}
		// System.out.println(max);

		// for(int []t:temp_a)System.out.println(Arrays.toString(t));
		a=tmp;
		return max;
	}

	private static int ccel() {// 열
		int tmp[][]=new int[101][101];
		int max = 0;
		for (int i = 0; i < cmax;i++) {// 모든 열 연산
			int temp[] = new int[a.length];
			for (int j = 0; j < rmax; j++) {
				temp[j] = a[j][i];// 열추출 리스트
			}
			ArrayList<int[]> p = new ArrayList<>();
			int nums[] = countValue(temp);// 열 카운트
			boolean check[] = new boolean[101]; // 중복체크 최대가 101번
			for (int j = 0; j < temp.length; j++) {// 열카운트별로 순서쌍 표시
				if (!check[temp[j]] && temp[j] != 0) {
					int te[] = new int[] { temp[j], nums[temp[j]] };
					p.add(te);
					check[temp[j]] = true;
				}
			}
			p.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int a = o1[1] - o2[1];
					if (a == 0)
						return o1[0] - o2[0];
					return a;
				}
			});

			// 열 정렬된 상태
			int cnt = 0;
			for (int j = 0; j < p.size(); j++) {
				tmp[cnt++][i] = p.get(j)[0];
				tmp[cnt++][i] = p.get(j)[1];
				max = Math.max(cnt, max);
			}

		}
		a=tmp;
		return max;
	}

	static int[] countValue(int[] list) {
		int[] nums = new int[101];// 최대 100
		for (int i = 0; i < list.length; i++) {
			nums[list[i]] += 1;
		}
		return nums;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
