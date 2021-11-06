import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_7579_앱{
	static class App {
		int mem, cost;

		public App(int mem, int cost) {
			super();
			this.mem = mem;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		App [] apps = new App[N+1];
		
		int sumCost = 0;
		
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 1 ; i <= N ;i++) {
			apps[i] = new App(Integer.parseInt(st.nextToken()),Integer.parseInt(st2.nextToken()));
			sumCost += apps[i].cost;
		}
		
		int [][] dp = new int [N+1][sumCost+1];
		int ans = 10001;
		
		for (int i = 1 ; i <= N ; i++) {
			for (int j = 0 ; j <= sumCost ; j++) {
				if (j < apps[i].cost) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - apps[i].cost] + apps[i].mem);
				}
				if (dp[i][j] >= M) ans = Math.min(ans, j);
			}
		}
		System.out.println(ans);
		
	}
}
