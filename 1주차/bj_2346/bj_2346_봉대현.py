import sys
N=int(sys.stdin.readline())
n_list=list(map(int,sys.stdin.readline().split()))
#터진 풍선 체크
visit=[False]*N

idx=0
ans=[]
check=0
while True:
    cnt=0
    visit[idx]=True
    ans.append(idx+1)
    check+=1
    if check==N: break
    move = n_list[idx]
    if move>0:
        while True:
            idx+=1
            if idx==N:
               idx=0
            if not visit[idx]:
                cnt+=1
                if cnt==move:
                    break
    else:
        move=abs(move)
        while True:
            idx-=1
            if idx<0:
                idx=len(n_list)-1
            if not visit[idx]:
                cnt+=1
                if cnt==move:
                    break
for a in ans:
    print(ans,end=" ")
