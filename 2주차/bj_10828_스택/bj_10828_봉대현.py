import sys

nlist=[]

def push(x):
    nlist.append(x)

def pop():
    if nlist:
        k=nlist[-1]
        del nlist[-1]
        return k
    else:
        return -1

def size():
    return len(nlist)

def empty():
    if nlist:
        return 0
    else:
        return 1

def top():
    return nlist[-1] if nlist else -1


for _ in range(int(sys.stdin.readline())):
    order=sys.stdin.readline().rstrip().split()
    command=order[0]
    if command =='push':
        push(order[1])
    elif command=='pop':
        print(pop())
    elif command=='size':
        print(size())
    elif command=='empty':
        print(empty())
    elif command=='top':
        print(top())