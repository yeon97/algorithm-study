import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N, L;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			int [] flavors = new int [N+1];
			int [] calories = new int [N+1];
			
			for (int i = 1 ; i <= N ; i++) {
				st = new StringTokenizer(br.readLine());
				flavors [i] = Integer.parseInt(st.nextToken());
				calories [i] = Integer.parseInt(st.nextToken());
			}
			
			int [][] dp = new int [N+1][L+1];
			
			for (int i = 1 ; i <= N ; i++) {
				for (int j = 1 ; j <= L ; j++) {
					if (calories[i] <= j) {
						dp[i][j] = Math.max(dp[i-1][j], flavors[i]+dp[i-1][j-calories[i]]);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			sb.append("#"+tc+" "+dp[N][L]+"\n");
		}
		System.out.println(sb);
	}
}
