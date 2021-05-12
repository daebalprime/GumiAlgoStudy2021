from itertools import permutations

def isMatchId(user,ban):
    for i in range(len(user)):
        if(ban[i]=='*'):
            continue
        if(user[i]!=ban[i]):
            return False    
    return True

def check(user,banned):
    
    for i in range(len(banned)):
        if len(user[i]) != len(banned[i]):
            return False
        if not isMatchId(user[i],banned[i]):
            return False
    
    return True
    
def solution(user_id, banned_id):
    n=len(banned_id)
    perm=list(permutations(user_id,n))
    
    answer=[]
    
    for p in perm:
        if check(p,banned_id):
            p=set(p)
            if p not in answer:
                answer.append(p)
    return len(answer)