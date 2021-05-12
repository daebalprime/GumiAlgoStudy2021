import java.util.*;
class Solution {
    
    static int dx[]={0,1,-1,0};
    static int dy[]={1,0,0,-1};
    static int ans;
    public int solution(int[][] board) {
        
        ans=Integer.MAX_VALUE;
        ArrayDeque<info>q=new ArrayDeque<>();
        int n=board.length;
        //방향이 -1인 이유 오른쪽 아래로 이동가능하므로
        q.add(new info(0,0,-1,0));
        board[0][0]=1;
        
        while(!q.isEmpty()){
            info cnt=q.poll();
            //도착지점
            if(cnt.x==n-1&&cnt.y==n-1){
                ans=Math.min(ans,cnt.cost);
                continue;
            }
            
            for(int k=0;k<4;k++){
                int nx=cnt.x+dx[k];
                int ny=cnt.y+dy[k];
                if(0<=nx&&0<=ny&&nx<n&&ny<n&&board[nx][ny]!=1){
                    int next_cost=0;
                    
                    if(cnt.d==-1 || cnt.d==k){//직선 코스일때
                        next_cost=cnt.cost+100;
                    }else{
                        next_cost=cnt.cost+100+500;
                    }
                    //처음 가는곳이라면 비용 저장
                    if(board[nx][ny]==0){
                        board[nx][ny]=next_cost;
                        q.add(new info(nx,ny,k,next_cost));
                    }
                    else if(board[nx][ny]>=next_cost){//비용이 같거나 작으면 갱신
                        board[nx][ny]=next_cost;
                        q.add(new info(nx,ny,k,next_cost));
                    }
                
                }
            }
            
        }
        
        return ans;
    }
    static class info{
        int x;
        int y;
        int d;
        int cost;
        
        
        info(int x,int y,int d,int cost){
            this.x=x;
            this.y=y;
            this.d=d;
            this.cost=cost;
            
        }
        public String toString(){
            return this.x+" "+this.y+" "+this.d+" "+this.cost;
        }
    }
}