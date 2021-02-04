import sys

N,P=map(int,sys.stdin.readline().split())
stack=[[0] for _ in range(7)]
#손가락 움직임 체크
res=0
for _ in range(N):
    #줄번호와 프렛번호 입력
    r,p=map(int,sys.stdin.readline().split())
    # 프렛번호가 작으면 번호보다 큰값손 다떼고 프렛누르기
    while stack[r][-1] > p:
        stack[r].pop()
        res += 1
    #프렛번호가 같으면 다음 음
    if stack[r][-1]==p:
        stack[r].pop()
        res-=1

    # i번 줄에서 마지막 프렛보다 높은 음이면 추가
    stack[r].append(p)
    res+=1
print(res)
