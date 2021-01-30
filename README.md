# GumiAlgoStudy2021
SSAFY 구미 4반 알고리즘 스터디입니다. 다들 화이팅!!

### :pencil: Rule  
- 스터디 시간: 매주 목요일 9시  
- 일주일 동안 7문제 풀기 (문제는 매주 정하기!!)   
- [문제 정하는 문서(임시)](https://docs.google.com/spreadsheets/d/1r6eQ5l23U5M79ySk9kqvcp5whVD2b5WGxsDOyWUgoC4/edit?usp=sharing)
- [백준 문제집](https://www.acmicpc.net/group/workbook/list/10053)

### :apple: How to Contribute   
1. 매주 새 디렉터리를 만듭니다. (ex. 1주차, 2주차 ...)
2. 디렉터리에 문제 디렉터리를 또 만듭니다. (ex. 백준 1000번 문제라면 bj_1000)
3. 문제 디렉터리에 각자 푼 문제를 추가합니다.

#### 1. 파일 생성/업로드 규칙   
파일명을 n주차/bj_1000/bj_1000_홍길동.java으로 해서 추가합니다. (n주차, bj_100은 디렉터리, bj_1000_홍길동.java는 파일)    

#### 2. Push 규칙  
-> pull부터 합니다.  
```
$ git pull <remote 이름> master
```
-> pull했는데 해당 주차의 디렉터리가 안보이면 따로 만들어 주세요.  
-> 프로젝트명/n주차/bj_100/bj_1000_홍길동.java 형식에 맞게 저장 후 commit&push 해주세요.
```
$ git add .
$ git commit -m "bj_1000_홍길동"
$ git push <remote 이름> master
```

> push할 때 conflict 생길 경우 pull 한번 해주고 다시 하면 됩니다.


### :banana: How to Code Review   
#### 1. Commit History로 리뷰하는 방법 
다른 사람이 커밋한 데다가 댓글 다는 방식 =>
[예시](https://github.com/ohgyun/using-github-for-code-reviews/commit/8a85b15805237214aea83a1131f0548b3b69a2d8)    

#### 2. Pull Request로 리뷰하는 방법   
- [fork해서 Pull Request 보내는 법](https://wayhome25.github.io/git/2017/07/08/git-first-pull-request-story/)  
- [fork된 레포지토리 최신상태 유지하는 법](https://jybaek.tistory.com/775)   
1) 새로운 branch를 하나 만듭니다.  
2) 새로 만든 branch에 코드를 push합니다.  
3) push 완료 후 GitHub branch 페이지에 들어오면 Pull Request(PR)할건지 버튼이 생깁니다. 클릭!
4) 코드 리뷰 받고 <b>스터디 시간 전에 merge</b>하면 됩니다. (merge 후 branch는 삭제해도 됩니다.)
리뷰는 오픈된 PR에 하면 됩니당.   
   
#### 일단 이렇게 정리해 봤습니다,, 보완할 부분 있으면 자유롭게 수정해주세요! :smile:
