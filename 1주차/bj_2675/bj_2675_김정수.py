tc = int(input())

for t in range(tc):
    value = input().split(' ')
    n = int(value[0])
    s= value[1]
    output = ''
    for i in range(len(s)):
        for j in range(n):
            output += s[i]
    print(output)
