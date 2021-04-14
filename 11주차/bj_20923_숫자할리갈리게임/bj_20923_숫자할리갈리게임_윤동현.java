import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main_bj_s1_20923_숫자할리갈리게임 {

	static ArrayDeque<Integer> dodo,su,gdodo,gsu;
	static int N,M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dodo = new ArrayDeque<>();
		su = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			dodo.offer(Integer.parseInt(st.nextToken()));
			su.offer(Integer.parseInt(st.nextToken()));
		}

		//마지막에 들어있는게 젤 위에 있는것

		gdodo = new ArrayDeque<>();
		gsu = new ArrayDeque<>();

		int g_do = 0;
		int s_do = 0;

		for(int i=0; i<M; i++) {
			if(i%2 == 0) { // 도도 차례
				g_do = dodo.pollLast();
				gdodo.offer(g_do);
			}else { // 수연 차례
				s_do = su.pollLast();
				gsu.offer(s_do);
			}

			if(dodo.isEmpty() || su.isEmpty()) break;

			if(g_do == 5 || s_do == 5) {
				//도도가 종을 친다
				while(!gsu.isEmpty()) {
					dodo.addFirst(gsu.pollFirst());
				}
				while(!gdodo.isEmpty()) {
					dodo.addFirst(gdodo.pollFirst());
				}
				g_do = s_do = 0;
			}

			if((!gdodo.isEmpty() && g_do + s_do == 5) ||
				(!gsu.isEmpty() && g_do + s_do == 5)) {
				while(!gdodo.isEmpty()) {
					su.addFirst(gdodo.pollFirst());
				}
				while(!gsu.isEmpty()) {
					su.addFirst(gsu.pollFirst());
				}
				g_do = s_do = 0;
			}
		}

		if(dodo.size() > su.size()) {
			System.out.println("do");
		}else if(dodo.size() < su.size()) {
			System.out.println("su");
		}else System.out.println("dosu");
        br.close();
	}
}