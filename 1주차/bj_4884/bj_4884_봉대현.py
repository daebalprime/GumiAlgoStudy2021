import sys
while True:
    X=Y=0
    G,T,A,D=map(int,sys.stdin.readline().split())
    if (G==-1 and T==-1 and A==-1 and D==-1):
        break;
    #조별리그 경기수
    groups=0
    for i in range(1,T):
        groups+=i
    groups*=G
    #print(groups)

    #토너먼트 경기수
    t = A * G + D
    # 2의 제곱꼴이면?
    if bin(t)[2:].count('1') ==1:
        X+=(t-1)
    else: #2의 제곱꼴이아니면 가까운것
        Y=(2**(len(bin(t)[2:])))-t
        X+=(2**(len(bin(t)[2:]))-1)
    X+=groups
    print(f'{G}*{A}/{T}+{D}={X}+{Y}')