package wk2.bj18258;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			int[] s = new int[2000000];
			int T = Integer.parseInt(br.readLine());
			int size = 0;
			int f = 0;
			for(int tc = 0; tc < T; tc++) {
				String key = br.readLine();
				switch (key) {
				default:
					StringTokenizer st = new StringTokenizer(key);
					st.nextToken();
					s[f+(size++)] = Integer.parseInt(st.nextToken());
					continue;
				case "pop":
					if(size == 0) {
						bw.append("-1"); 
					}
					else {
						bw.append(Integer.toString(s[f++]));
						size--;
					}
					break;
				case "size":
					bw.append(Integer.toString(size));
					break;
				case "empty":
					bw.append(size==0 ? "1" : "0");
					break;
				case "front":				
					bw.append(size==0 ? "-1" : Integer.toString(s[f]));
					break;
				case "back":
					bw.append(size==0 ? "-1" : Integer.toString(s[f+size-1]));
					break;
				}
				bw.newLine();
			}
			bw.flush();
		}catch (IOException e){
			
		}
		
	}

}
