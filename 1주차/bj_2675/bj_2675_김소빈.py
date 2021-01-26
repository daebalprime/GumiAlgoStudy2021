def main():
  num = int(input())

  for i in range(num):
    string = list(input().split())
    n = int(string[0])
    answer = ''
    for j in range(len(string[1])):
      answer += string[1][j] * n
    print(answer)
main()