import sys

N=int(sys.stdin.readline())
n_list=list(map(int,sys.stdin.readline().split()))

check=True
for i in range(N):
    if i%2==n_list[i]%2:
        check=False

print("YES" if check else "NO")
