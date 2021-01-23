result=[]
for i in range(10):
    A=int(input())
    result.append(A)

num=[]
for i in result:
    num.append(int(i%42))
print(len(list(set(num))))