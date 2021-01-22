used = {}
for i in range(10):
    n = int(input())
    
    if n%42 not in used.keys():
        used[n%42] = 1
        

print(len(used.keys()))
