import sys
from collections import deque
#벨트 길이, 종료 조건
N,K=map(int,sys.stdin.readline().split())
#0 올라가는 위치 N-1 내려가는 위치
#벨트 내구도
belt=deque(map(int,sys.stdin.readline().split()))
cnt=0
robots=deque([0]*(2*N))
while True:

    if belt.count(0)>=K:
        print(cnt)
        break

    #1.벨트가 한칸 회전
    belt.rotate(1)
    robots.rotate(1)
    #떨어지는 위치 로봇 cut
    if robots[N-1]!=0:
        robots[N-1]=0
    #2. 로봇 이동
    for i in range(N-2,-1,-1):
        if robots[i+1] ==0 and belt[i+1] >=1 and robots[i]==1:
            robots[i+1]=robots[i]
            robots[i]=0
            belt[i+1]-=1

    if robots[N- 1] != 0:
        robots[N- 1] = 0
    #3. 올라가는 위치체크 후 로봇 생성
    if robots[0]==0 and belt[0]>=1:
        robots[0]=1
        belt[0]-=1
    cnt += 1




