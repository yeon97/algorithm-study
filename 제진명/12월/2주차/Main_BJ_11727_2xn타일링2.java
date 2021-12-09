import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	2021. 12. 8
 * 	mem: 11532KB	time: 92ms
 */

public class Main_BJ_11727_2xn타일링2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int [n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2 ; i <= n ; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		}
		
		System.out.println(dp[n]);
	}
}
