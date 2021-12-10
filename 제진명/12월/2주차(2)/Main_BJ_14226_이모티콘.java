package algo211209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 	2021. 12. 10
 * 	mem: 22420KB	time: 152ms
 */

public class Main_BJ_14226_이모티콘 {
	static int S, ans;
	static int [][]dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());
		dp = new int [S+1][S*2+1];
		for (int i = 0 ; i <= S ; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		ans = Integer.MAX_VALUE;

		dfs(1, 0, 0);

		System.out.println(ans);
	}

	static void dfs(int now, int copy, int cnt) {
		if (dp[copy][now] <= cnt) return;
		dp[copy][now] = cnt;
		
		if (cnt >= ans) {
			return;
		}
		if (now == S) {
			ans = Math.min(ans, cnt);
			return;
		} else if (now > S) {
			ans = Math.min(ans, cnt + (now - S));
			return;
		}

		dfs(now + now, now, cnt + 2);
		if (copy != 0) {
			dfs(now + copy, copy, cnt + 1);
		}
		if (now > 1) {
			dfs(now - 1, copy, cnt + 1);
		}
	}
}
