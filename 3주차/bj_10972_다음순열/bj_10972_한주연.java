import java.util.*;
import java.io.*;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// 초기화
    	n = stoi(br.readLine()); 
    	int[] perm = new int[n];
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		perm[i] = stoi(stk.nextToken());
    	}
    	boolean isFinded = false;
    	// 1번 : 오른쪽 끝에서 부터 탐색
    	end: for(int i = n - 1; i >= 1; i--) {
			// 2번 : i-1 < i인 경우
    		if(perm[i] > perm[i-1]) {
    			int strd = i - 1;	// 3번 : 해당 값을 기준(standard)으로 정한다
    			for(int j = n - 1; j >= i; j--) {
				// 4번 : 오른쪽부터 왼쪽영역으로 움직이면서 기준 값과 크기를 비교
    				if(perm[strd] < perm[j]) {
    					// 5번 : 크다면 자리를 바꾼다.
    					int temp = perm[strd];
    					perm[strd] = perm[j];
    					perm[j] = temp;
    					// 6번 : 오른쪽영역의 숫자를 오름차순으로 정렬해준다.
    					int[] forsort = new int[n-i];
    					for(int k = 0; k < n-i; k++)
    						forsort[k] = perm[i+k];
    					Arrays.sort(forsort);
    					for(int k = i; k < n; k++)
    						perm[k] = forsort[k - i];
    					// 7번 : 다음 순열을 찾았으므로, 알려준다.
    					isFinded = true;
    					break end;
    				}
    			}
    		}
    	}
	// 순열의 마지막 끝인 경우
    	if(!isFinded) {
    		System.out.println(-1);
			br.close();
    		return;
    	}
    	
    	for(int v : perm)
    		System.out.print(v + " ");
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}