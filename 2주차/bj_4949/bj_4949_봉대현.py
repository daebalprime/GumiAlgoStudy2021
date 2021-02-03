import sys

while True:
    input_list=sys.stdin.readline().rstrip()
    if input_list=='.':
        break
    sa=[i for i in input_list.rstrip()]
    stack=[]
    check=True
    for s in sa:
        if s=='(' or s=='[':
            stack.append(s)
        elif s==')':
            if stack and stack[-1]=='(':
                stack.pop()
            else:
                check=False
                break

        elif s==']':
            if stack and stack[-1]=='[':
                stack.pop()
            else:
                check=False
                break

    if not stack and check:
        print("yes")
    else:
        print("no")