package bj_1316;

import java.util.Scanner;

public class bj_1316_윤동현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;
        for(int i=0; i<N; i++) {
            String s = sc.next();
            String[] str = s.split("");
            int[] alphabet = new int[26];
            boolean isCheck = false;
            for(int j=0; j<str.length; j++) {
                if(j+1 < str.length && str[j].equals(str[j+1])) continue;
                if(alphabet[str[j].charAt(0) - 'a'] != 0) {
                    isCheck = true;
                    break;
                }
                alphabet[str[j].charAt(0) - 'a']++;
            }
            if(!isCheck) {
                cnt++;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
