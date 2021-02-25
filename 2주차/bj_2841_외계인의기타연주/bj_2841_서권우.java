import java.util.Scanner;
import java.util.Stack;

public class bj_2841_서권우 {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int f = sc.nextInt();
        int ans = 1;
 
        Stack<Integer>[] stack = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            stack[i] = new Stack<Integer>();
            stack[i].push(0);
        }
 
        stack[sc.nextInt()].push(sc.nextInt());
 
        for (int i = 1; i < n; i++) {
            int ln = sc.nextInt();
            int fn = sc.nextInt();
 
            while (stack[ln].peek() > fn) {
                stack[ln].pop();
                ans++;
            }
 
            if (stack[ln].peek() != fn) {
                stack[ln].push(fn);
                ans++;
            }
        }
        System.out.println(ans);


		/*Stack<Integer> plet = new Stack<>();
		Stack<Integer> line = new Stack<>();
		
		int Finger = 1;
		int N = sc.nextInt(); // 음의 수
		int P = sc.nextInt();
		
		int L = sc.nextInt();
		P = sc.nextInt();
		plet.push(P);
		line.push(L);
		
		for (int i = 1; i < N; i++) {
			L = sc.nextInt();
			P = sc.nextInt();
			
			if(line.peek() < L || line.peek() >= L) {
				line.pop();
				line.push(L);
				Finger++;
//				System.out.println(Finger);
			} 
			if(plet.peek() < P || plet.peek() > P) {
				plet.pop();
				plet.push(P);
				Finger++;
//				System.out.println(Finger);
			} 
		}
		System.out.println(Finger);
		
		
		sc.close();
		 */
		
	}

}
