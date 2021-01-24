# 홀수는 홀수 위치에, 짝수는 짝수 위치에 있어야 정렬할 수 있다.
# 3개 단위로 숫자를 뒤집기 때문에 +=1의 위치로는 절대 이동할 수 없기 때문.

n = int(input())
arr = list(map(int, input().split(' ')))

can_sort = True

for i in range(1, n+1):
    if arr[i-1]%2 != i%2:
        can_sort = False

if can_sort is True:
    print('YES')
else:
    print('NO')
