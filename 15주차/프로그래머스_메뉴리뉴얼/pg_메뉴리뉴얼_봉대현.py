from itertools import combinations
import collections

def solution(orders, course):
    answer = []
    combi=[]
    for order in orders:
        order_arr=[i for i in order]
        order_arr.sort()
        for c in course:
            for i in list(map(''.join,combinations(order_arr,c))):
                combi.append(i)
    #요소 별 개수 체크
    dic=collections.Counter(combi)
    dic=sorted(dic.items(),key=lambda x: x[1],reverse=True)
    #print(dic)
    
    ans=[]
    for c in course:
        maxv=0
        for i in range(len(dic)):
            if dic[i][1]>=2 and len(dic[i][0])==c:
                if(dic[i][1]>=maxv):
                    ans.append(dic[i][0])
                    maxv=dic[i][1]
    answer=sorted(ans)
    
    return answer


