"""아이디어 메모
친구:학생은 자신과 반 등수의 차이가 K넘으면 친구  X
좋은 친구 : 친구 중 이름의 길이 같다
입력-
N :학생 수 K: 등수 차이 >=
이름 : 성적순

출력 - 좋은 친구 몇쌍?

이름 길이와 등수를 리스트에 저장하여 등수 안에 드는 것들 추리고
1.*index를 이용하여 K만큼만 비교 * 등수 중에서 이름이 같은 사람 체크
-1.N^2 이여서 안될거같다.
2. deque를 이용하여 popleft하면서 K명 슬라이싱. 비교 -N^2...맞네..
3. 길이가 같은 이름끼리 묶어서 비교
4. deque를 이용하여 앞 뒤로 빼가면서 판단.?
"""

import sys
from _collections import deque
N,K=map(int,sys.stdin.readline().split())
students=[len(sys.stdin.readline().rstrip()) for i in range(N)]
q=[deque([])for _ in range(21)]
cnt=0
#마지막 사람은 등수비교 X
for rank in range(N):
    #사람 수 조절
    if rank>K:
        q[students[rank-K-1]].popleft()
    #이름넣기전에 쌍이 되는지 판단
    cnt+=len(q[students[rank]])
    #이름 길이 추가
    q[students[rank]].append(1)
    #print(q)
print(cnt)
