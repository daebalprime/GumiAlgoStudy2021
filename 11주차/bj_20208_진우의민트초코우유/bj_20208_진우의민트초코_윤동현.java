import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main_bj_g5_20208_진우의민트초코 {

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static ArrayList<Node> mint;
    static Node home;
    static int[][] map;
    static int[] perm;
    static boolean[] visited;
    static int N,M,H,res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        H = stoi(st.nextToken());

        map = new int[N][N];
        mint = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] == 1) home = new Node(i, j);
                if(map[i][j] == 2) mint.add(new Node(i,j));
            }
        }

        visited = new boolean[mint.size()];
        dfs(home.x, home.y, 0, M);

        System.out.println(res);
        br.close();
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static void dfs(int x, int y, int cnt, int h) {
        if(cnt > res && Math.abs(x-home.x) + Math.abs(y-home.y) <= h) res = cnt;
        if(h <= 0 || cnt == mint.size()) return;

        for(int i=0; i<mint.size(); i++) {
            if(visited[i] || Math.abs(x-mint.get(i).x) + Math.abs(y-mint.get(i).y) > h) continue;
            visited[i] = true;
            dfs(mint.get(i).x, mint.get(i).y, cnt+1, h + H - (Math.abs(x-mint.get(i).x) + Math.abs(y-mint.get(i).y)));
            visited[i] = false;
        }
    }
}