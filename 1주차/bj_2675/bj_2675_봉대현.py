num=int(input())
ans=[]
for i in range(num):
    s=input().split()
    a=[k for k in s[1]]
    code=""
    for n in a:
        code+=n*int(s[0])
    ans.append(code)
for m in ans:
    print(m)