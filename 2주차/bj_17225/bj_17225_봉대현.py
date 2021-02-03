"""아이디어
입력 : 각각 포장하는 시간 ,손님의 수( 주문 시각, 포장지색,선물개수)
두사람이 동시에 선물포장할때는 상민이부터
상민 - B
지수 - R
현재 남아있는 선물 중 가장 앞에 있는 선물부터 -- queue
반복문을 현재 남아있는 선물로 판단
시간이 계속 흐른다.
--
주문한 시간이 되면 작업공간에 선물개수만큼 공간에 추가
작업시간 a,b시간 지나면 popleft
상민이의 작업 공간 queue
지수의 작업 공간 queue
"""
import sys
from _collections import deque
a,b,n=map(int,sys.stdin.readline().split())
space=deque([])
gift=0
#포장가능한 시간 체크
saveB=saveR=0
#작업장에 올림
for _ in range(n):
    t,c,m=sys.stdin.readline().split()
    t=int(t)
    #각자 포장 가능한 시간 체크
    if c == 'B':
        t=max(t,saveB)
        for _ in range(int(m)):
            space.append([t, c])
            t += a
        #포장이 끝나는 시간저장
        saveB=t
    else:
        t = max(t, saveR)
        for _ in range(int(m)):
            space.append([t, c])
            t += b
        saveR=t
#시간이 빠른 시간과 B부터
space=sorted(space,key=lambda x :(x[0],x[1]))
space=deque(space)
#print(space)

sang=[]
ji=[]
#선물 번호
gn=1
while space:
    #손님이 주문한 시간되면 포장시작
    t,c=space.popleft()
    if c=='B':
        sang.append(gn)
    elif c=='R':
        ji.append(gn)
    gn+=1

print(len(sang))
for i in range(len(sang)):
    print(sang[i],end=" ")
print()
print(len(ji))
for i in range(len(ji)):
    print(ji[i],end=" ")
