import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	static int n, m, result;
	static Integer[] crane, box;
	static boolean[] moved;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	// 초기화
    	n = stoi(br.readLine());
    	crane = new Integer[n];
    	stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++)
    		crane[i] = stoi(stk.nextToken());
    	m = stoi(br.readLine());
    	box = new Integer[m];
    	stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < m; i++)
    		box[i] = stoi(stk.nextToken());
    	moved = new boolean[m];
    	
		// 내림차순으로 크레인과 박스를 정렬
    	Arrays.sort(crane, Collections.reverseOrder());
    	Arrays.sort(box, Collections.reverseOrder());
    	
		// 박스를 못 옮기는 크레인이 존재 할 시
    	if(box[0] > crane[0]) {
    		System.out.println(-1);
    		return;
    	}
    	
    	int boxCnt = m, idx = 0;
    	while(boxCnt != 0) {		// 모든 박스를 옮긴다.
    		
    		idx = 0; // 크레인의 순서
    		for(int i = 0; i < m; i++) {
    			if(idx == n)		// n개의 크레인이 다 박스를 옮겼을 때
    				break;
    			if(!moved[i] && box[i] <= crane[idx]) {		
    				moved[i] = true;		// 해당하는 박스는 옮겨졌다고 표시한다.
    				idx++;					// 다음 크레인으로 넘어간다
    				boxCnt--;				// 총 박스 개수를 하나 줄인다
    			}
    			
    		}
    		result++;		// n개의 크레인이 한번씩 박스를 옮겼으므로 1분 증가
    	}
    	
    	System.out.println(result);
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}