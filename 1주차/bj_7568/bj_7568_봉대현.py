n=int(input())
weight=[]
for i in range(n):
    a=list(map(int,input().split()))
    weight.append(a)

grade=[0]*n

for i in range(len(weight)):
    rank=1
    for j in range(0,len(weight)):
        if weight[i][0] < weight[j][0] and weight[i][1] < weight[j][1]:
            rank+=1
    grade[i] = rank
for i in grade:
    print(i,end=' ')