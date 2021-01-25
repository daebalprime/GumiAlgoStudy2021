def main():
  a = []
  answer = []
  for i in range(10):
    tmp = int(input())
    tmp = tmp % 42
    a.append(tmp)

  for i in a:
    if i not in answer :
      answer.append(i)
    else:
      continue
  
  print(len(answer))
main()