package bj_7568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_7568_윤동현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        bulk[] pepole = new bulk[N];
        int[] score = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pepole[i] = new bulk(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<N; i++) {
            score[i] = 1;
            for(int j=0; j<N; j++) {
                if(pepole[i].weight < pepole[j].weight && pepole[i].height < pepole[j].height) score[i]++;
            }
        }
        
        for(int a: score)
            System.out.print(a+" ");
            
        br.close();
    }
    
    static class bulk {
        int weight;
        int height;
        bulk(int weight,int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
