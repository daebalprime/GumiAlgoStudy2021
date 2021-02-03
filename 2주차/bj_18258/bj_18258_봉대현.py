import sys
from collections import deque

def push(x):
    q.append(x)

def pop():
    #del 시에는 앞으로 땡겨오는 시간이 좀오래걸린다.
    if q:
        return q.popleft()
    else:
        return -1

def size():
    return len(q)

def empty():
    if q:
        return 0
    else:
        return 1

def front():
    if q:
        return q[0]
    else:
        return -1

def back():
    if q:
        return q[-1]
    else:
        return -1

N=int(sys.stdin.readline())
q=deque([])
for _ in range(N):
    order=sys.stdin.readline().rstrip().split()
    command=order[0]

    if command=='push':
        push(order[1])
    elif command=='front':
        print(front())
    elif command=='back':
        print(back())
    elif command=='size':
        print(size())
    elif command=='empty':
        print(empty())
    elif command=='pop':
        print(pop())