package bj_4884;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_4884_윤동현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long G = Integer.parseInt(st.nextToken());
            long T = Integer.parseInt(st.nextToken());
            long A = Integer.parseInt(st.nextToken());
            long D = Integer.parseInt(st.nextToken());
            if(G == -1) break;

            long round1 = ((T*(T-1))/2)*G;
            long tm = (G*A)+D;
            long exponent = G*A;

            if((tm&(-tm)) != tm) {
                while(exponent < tm) {
                    exponent = exponent << 1;
                }
            } else {
                exponent = tm;
            }

            long X = round1 + exponent-1;
            long Y = exponent-tm;
            System.out.println(G+"*"+A+"/"+T+"+"+D+"="+X+"+"+Y);
            br.close();
        }
    }//end main
}//end class