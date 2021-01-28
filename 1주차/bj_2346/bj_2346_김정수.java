import java.util.Scanner;

class Main
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int [] balloons = new int[N];
		
		for(int i=0;i<N;i++) {
			balloons[i] = sc.nextInt();
		}
		
		int index = 0; // 첫번째부터 터뜨리기
		int move = 0; // 앞으로 움직일 풍선
		int dir = 0; //움직일 방향
		int remain = N; // 남은 풍선
		
		int [] rank = new int[N]; // 풍선 터진 순서
		int rankIndex = 0; // rank 배열에 넣어야할 인덱스
		
		while(remain > 0) {
			if(move!= 0) {
				// 움직여야할 경우 현재 위치에 풍선 있으면 카운트, 없으면 넘어가기
				if(balloons[index] != 0) {
					// 풍선 있는 경우 이동
					if(move > 0) {
						index ++;
						move --;
					}else {
						index --;
						move ++;
					}
				}else {
					//없으면 인덱스만 이동
					if(move > 0) {
						index ++;
					}else {
						index --;
					}
				}
			}else {
				// 도착한 경우(풍선이 있는 경우) 터뜨리고 move 값 새로 지정하기
				if(balloons[index] != 0) {
					// 풍선 있는 경우 터뜨리기
					move = balloons[index]; // move 값 새로 지정
					dir = move;
					balloons[index] = 0; //터뜨리기
					rank[rankIndex++] = index+1;
					remain --;
					// 움직이기
					if(move > 0) {
						index ++;
						move --;
					}else {
						index --;
						move ++;
					}
				}else {
					//풍선 없으면 인덱스만 이동
					if(dir > 0) {
						index ++;
					}else {
						index --;
					}
				}
			}
			// 다음 도착할 인덱스 확인 및 범위 넘으면 조정하기
			if(index < 0) {
				index = N-1;
			}else if(index > N-1){
				index = 0;
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(rank[i] + " ");
		}
	}
}