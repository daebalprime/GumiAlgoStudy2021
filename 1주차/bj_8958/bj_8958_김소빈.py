def main():
  num = int(input())
  for i in range(num):
    tmp = input()
    index = 0
    score = 0
    for j in tmp:
      if j == "O":
        index += 1
        score += index
      else:
        index = 0
    print(score)
main()