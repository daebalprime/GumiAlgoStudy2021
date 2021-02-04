package BJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class bj_1966_������ {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_bj_1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Queue�� �����
		LinkedList<int[]> q = new LinkedList<>();
		// 1. �׽�Ʈ ���̽��� ���� �־�����.
		int T = Integer.parseInt(br.readLine());
		int cnt, N, M, imp;
		// 2. ���� ��ŭ �ݺ��Ѵ�.
		for (int tc = 1; tc <= T; ++tc) {
			cnt = 0;
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);// ���������� �Է¹޴´�.
			M = Integer.parseInt(tmp[1]);// ã������ ������ ��ġ
			String[] tmp2 = br.readLine().split(" ");// �������� �Է¹޴´�.
			if (N == 1) {
				cnt++;
			} else {
				for (int i = 0; i < N; ++i) {// ���� ������ŭ �Է¹޴´�.
					imp = Integer.parseInt(tmp2[i]);
					q.offer(new int[] { i, imp });// �Է¹޴¼������
				}
				// 3. �˻�
				while (true) {
					boolean canPrint = true;
					// �μ� �������� �˻�(�ϳ��� ū�������� �Ұ���)
					for (int i = 1; i < q.size(); ++i) {
						if (q.peek()[1] < q.get(i)[1]) {
							canPrint = false;
							break;
						}
					}
					// �ڷ� ������ ���� �˻�
					if(canPrint) {
						cnt++;
						if(M==q.peek()[0]) break; //ã�°Ÿ� �׸�
						q.poll();
						
					}else { // ��ºҰ��� �ڷ� �ֱ�
						q.add(q.peek());
						q.poll();
					}
				}
			}
			// 4. ���
			System.out.println(cnt);
			q.clear();
		}
	}
}
