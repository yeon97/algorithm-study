package Algo_220413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_5525_IOIOI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		int[] cnt = new int[M];
		int ans = 0;

		for (int i = 1; i < M - 1; i++) {
			if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
				cnt[i + 1] = cnt[i - 1] + 1;

				if (cnt[i + 1] >= N && S.charAt(i - 2 * N + 1) == 'I') {
					ans++;
				}
			}
		}

		System.out.println(ans);

	}
}
