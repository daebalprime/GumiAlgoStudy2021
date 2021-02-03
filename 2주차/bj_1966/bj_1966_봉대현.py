import sys
T=int(sys.stdin.readline())

for _ in range(T):
    N,M=map(int,sys.stdin.readline().split())
    w=list(map(int,sys.stdin.readline().split()))
    q=[]
    for i in range(len(w)):
        q.append([i,w[i]])
    use=[]
    while q:
        check=False
        idx,cnt=q.pop(0)
        #현재 문서보다 중요도가 높은 문서 체크
        for w in q:
            if cnt<w[1]:
                q.append([idx,cnt])
                check=True
                break
        if not check:
            use.append(idx)
    print(use.index(M)+1)