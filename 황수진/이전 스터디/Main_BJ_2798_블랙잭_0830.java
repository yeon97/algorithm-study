import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_2798_블랙잭_0830 {

	static int N, M, ans, sub = Integer.MAX_VALUE;
	static int[] input, res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 카드의 개수
		M = sc.nextInt(); // 기준 수
		input = new int[N]; // 카드
		res = new int[3]; // 카드 3개 조합

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		combi(0, 0);

		System.out.println(ans);
		sc.close();
	}

	// r인 3인 조합 생성
	private static void combi(int cnt, int start) {
		if (cnt == 3) {
			find(Arrays.stream(res).sum());
			return;
		}

		for (int i = start; i < N; i++) {
			res[cnt] = input[i];
			combi(cnt + 1, i + 1);
		}
	}

	// 제일 가까운 수 찾기
	private static void find(int sum) {
		if (sum <= M) {
			int tmp = M - sum;
			if (tmp < sub) {
				sub = tmp;
				ans = sum;
			}
		}
	}

}
