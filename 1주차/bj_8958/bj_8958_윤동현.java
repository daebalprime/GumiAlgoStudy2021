package bj_8958;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_8958_윤동현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        int[] cnt = new int[N];

        for(int i=0; i<N; i++) {
            str[i] = br.readLine();
        }

        for(int i=0; i<N; i++) {
            int index = 0;
            for(int j=0; j<str[i].length(); j++) {
                if(str[i].charAt(j) == 'X') {
                    index = 0;
                    continue;
                }
                index++;
                cnt[i] += index;
            }
        }

        for(int i: cnt) {
            System.out.println(i);
        }
        br.close();
    }
}
