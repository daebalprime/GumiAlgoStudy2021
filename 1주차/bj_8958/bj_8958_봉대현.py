N=int(input())
m=[]

def fun(num):
    if num< 0:
        return 0
    else:
        return num+fun(num-1)
for i in range(N):
    m.append(input())
for i in range(N):
    result = 0
    n=m[i].split('X')
    for k in n:
        result+=fun(k.count('O'))
    print(result)