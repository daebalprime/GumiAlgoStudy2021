/*
17140번 - 이차원 배열과 연산
https://www.acmicpc.net/problem/17140
*/

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	static int rr,cc,k , result;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	//n = stoi(br.readLine());
    	
    	rr = stoi(stk.nextToken()) - 1;
    	cc = stoi(stk.nextToken()) - 1;
    	k = stoi(stk.nextToken());
    	
    	// 테스트 할때만 10, 10 크기임
    	arr = new int[100][100];
    	for(int i = 0; i < 3; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 3; j++) {
    			arr[i][j] = stoi(stk.nextToken());
    		}
    	}
    	HashMap<Integer, Integer> map = new HashMap<>();
		// Map.Entry 리스트 작성
		List<Entry<Integer, Integer>> list_entries;
		
    	int r = 3, c = 3, time = 0;
    	// 100보다 크면 잘라야함
    	// 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순
    	while(time <= 100) {
    		if(arr[rr][cc] == k) {
    			result = time;
    			break;
    		}
    		//행이 열보다 클때 R 연산
    		if(r >= c) {
    			int biglen = 0;
    			for(int i = 0; i < r; i++) {
    				for(int j = 0; j < c; j++) {
    					if(arr[i][j] == 0)
    						continue;
    					if(!map.containsKey(arr[i][j])){
    						map.put(arr[i][j], 1);
    					}
    					else {
    						map.replace(arr[i][j], map.get(arr[i][j]) + 1);
    					}
    				}
    				list_entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
    				Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							int diff = o1.getValue().compareTo(o2.getValue());
							if(diff == 0) {
								return o1.getKey().compareTo(o2.getKey());
							}
							return diff;
						}
					});
    				// 새롭게 정렬한 결과를 각 행에 넣어준다
    				int idx = 0;
    				for(Entry<Integer, Integer> entry : list_entries) {
    					arr[i][idx++] = entry.getKey();
    					arr[i][idx++] = entry.getValue();
    					if(idx == 100)
    						break;
    				}
    				biglen = Math.max(biglen, idx);
    				// 끝난 이후 0이 아닌 값들은 다 0 처리
    				for(int j = idx; idx < c; idx ++) {
    					if(arr[i][idx] != 0)
    						arr[i][idx] = 0;
    				}
    				map.clear();
    			}
    			// 열의 크기 갱신
    			c = biglen;
    		}
    		//열이 행보다 클때 C 연산
    		else {
    			int biglen = 0;
    			for(int i = 0; i < c; i++) {
    				for(int j = 0; j < r; j++) {
    					if(arr[j][i] == 0)
    						continue;
    					if(!map.containsKey(arr[j][i])){
    						map.put(arr[j][i], 1);
    					}
    					else {
    						map.replace(arr[j][i], map.get(arr[j][i]) + 1);
    					}
    				}
    				list_entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
    				Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							int diff = o1.getValue().compareTo(o2.getValue());
							if(diff == 0) {
								return o1.getKey().compareTo(o2.getKey());
							}
							return diff;
						}
					});
    				// 새롭게 정렬한 결과를 각 행에 넣어준다
    				int idx = 0;
    				for(Entry<Integer, Integer> entry : list_entries) {
    					arr[idx++][i] = entry.getKey();
    					arr[idx++][i] = entry.getValue();
    					if(idx == 100)
    						break;
    				}
    				biglen = Math.max(biglen, idx);
    				// 끝난 이후 0이 아닌 값들은 다 0 처리
    				for(int j = idx; idx < r; idx ++) {
    					if(arr[idx][i] != 0)
    						arr[idx][i] = 0;
    				}
    				map.clear();
    			}
    			// 행의 크기 갱신
    			r = biglen;
    		}
    		time++;
    	}
    	// 시간이 101초 라는 것은 100초를 초과했다는 것이므로 -1
    	if(time == 101)
    		System.out.println(-1);
    	else
    		System.out.println(result);
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}