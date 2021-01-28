package bj_2675;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class bj_2675_윤동현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer str = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(str.nextToken());
            String s = str.nextToken();
            
            for(int i=0; i<s.length(); i++) {
                for(int j=0; j<R; j++) {
                    sb.append(s.charAt(i));
                }
            }

            System.out.println(sb);
        }
        
        br.close();
    }//end main
}//end class