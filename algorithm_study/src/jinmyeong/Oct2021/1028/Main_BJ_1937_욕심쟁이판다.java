import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1937_욕심쟁이판다 {
	
	static int n;
	static int ans;
	static int [][] map;
	static int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	static int [][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		// 현 지점에서 출발하였을 때 최대 이동 횟수를 기록
		dp = new int[n][n];
		
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j++) {
				dfs(i, j, 1);
			}
		}
		
//		for (int i = 0 ; i < n ; i++) {
//			for (int j = 0 ; j < n ; j++) {
//				System.out.print(dp[i][j]+" ");;
//			}
//			System.out.println();
//		}
		
		System.out.println(ans);
	}
	
	static int dfs(int x, int y, int cnt) {		
		int end = 0;
		for (int d = 0 ; d < 4 ; d++) {
			int nx = x + D[d][0];
			int ny = y + D[d][1];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
				continue;
			}
			
			if (map[x][y] >= map[nx][ny]) continue;
			
			if (dp[nx][ny] != 0) {
				end = Math.max(end, dp[nx][ny]+cnt);
				continue;
			}
			
			end = Math.max(end, dfs(nx, ny, cnt+1));
		}
		
		end = end==0? cnt:end;
		dp[x][y] = Math.max(dp[x][y], end - cnt +1);
		ans = Math.max(ans, end);
		return end;
	}
}
