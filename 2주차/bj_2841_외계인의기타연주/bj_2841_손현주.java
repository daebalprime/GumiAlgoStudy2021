package BJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_2841_������ {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_bj_2841.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ���� ������ ������ ������ �Է¹޴´�.
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		// ���� �迭�� �����. 1���� ����, 2���� ����, 3���� ����,,,,,n��������
		Stack<Integer>[] guitar = new Stack[N];
		for(int i=0; i<N;++i) {
			guitar[i] = new Stack<>();
		}
		// ó���� �����Ѵ�.
		int cnt = 0;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());//��
			int p = Integer.parseInt(st.nextToken());//����
			
			// �ƹ��͵� �ȴ����� �ִ� ���¸� �׳� �ٷ� ��
			if(guitar[n].isEmpty()) {
				guitar[n].push(p-1);
				++cnt;
			}
			
			// �̹� �ִ� ���� �� ũ�� ������(�ݺ�)
			while(guitar[n].peek() > p-1) {
				guitar[n].pop();
				++cnt;
				if(guitar[n].size()==0) break; // �ƹ��͵� �ȵ�������� Ż��
			}
			
			// �Ȱ��� �� ������ ��� & �̹� ä���־��� ���
			if(!guitar[n].isEmpty() && guitar[n].peek()==p-1) continue; //�پ�ѱ�
			

			// �̹� �ִ� �� ���� �� ũ�� �׳� �ֱ� or ū������ �� ���� ä���ش�.
			guitar[n].push(p-1);
			++cnt;
		}
		System.out.println(cnt);
	}
}
