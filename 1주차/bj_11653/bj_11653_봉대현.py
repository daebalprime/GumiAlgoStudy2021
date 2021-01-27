import sys
n=int(sys.stdin.readline())
#소수 구하기
a = [False,False] + [True]*(n-1)
primes=[]

for i in range(2,n+1):
  if a[i]:
    primes.append(i)
    for j in range(2*i, n+1, i):
        a[j] = False

idx=0
#정수가 1이 될때까지 나누기
while n!=1:
    if n%primes[idx]==0:
        print(primes[idx])
        n/=primes[idx]
    else:
        idx+=1
