import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class bj_10972_윤동현 {
	
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

		if(!nextPermutation()) System.out.println(-1);
		else {
			for(int a:arr) System.out.print(a+" ");
			System.out.println();
		}
		br.close();
	}

	static boolean nextPermutation() {
		int i = N-1;
		//내림차순이 깨진 시점 파악
		while(i>0 && arr[i-1] >= arr[i]) i--;

		//i가 0이면 내림차순이 잘되어있다는것으로 n이 3이면 321의 끝상황
		if(i<=0) return false;

		int j = N-1;
		//2 1 4 3일때 현재 i가 가르키고있는것은 4이므로 i-1값보다 더큰 경우를 찾는다.
		while(arr[j] <= arr[i-1]) j--;

		//i,j swap
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;

		//그리고 i번째부터 오름차순 정렬
		//원래 내림차순으로 정렬된 상태라 뒤에서부터 바꿔주기만 하면된다!
		while(i < --N) {
			temp = arr[N];
			arr[N] = arr[i];
			arr[i] = temp;
			i++;
		}
		return true;
	}
}