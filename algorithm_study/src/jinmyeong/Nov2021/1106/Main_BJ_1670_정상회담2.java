import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_1670_정상회담2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final long INF = 987654321;
		
		int N = Integer.parseInt(br.readLine());
		
		if (N == 2) {
			System.out.println(1);
			return;
		}
		
		long [] dp = new long[N/2+1];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3 ; i <= N/2 ; i++) {
			for (int j = 2 ; j <= i*2 ; j += 2) {
				dp[i] += dp[j/2-1]*dp[(i*2-j)/2];
				dp[i] %= INF;
			}
		}
		
		System.out.println(dp[N/2]);
	}
}
