import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	2021. 11. 30
 * 	mem: 38668KB	time: 320ms
 */

public class Main_BJ_1520_내리막길 {
	static int M, N;
	static int[][] map;
	static int[][] dp;
	static int[][] D = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		dfs(0, 0);
		System.out.println(dp[0][0]);
	}

	static int dfs(int x, int y) {
		if (x == M - 1 && y == N - 1) {
			return 1;
		}

		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + D[d][0];
			int ny = y + D[d][1];

			if (nx < 0 || ny < 0 || nx >= M || ny >= N)
				continue;
			if (map[nx][ny] >= map[x][y])
				continue;

			dp[x][y] += dfs(nx, ny);
		}

		return dp[x][y];
	}
}
