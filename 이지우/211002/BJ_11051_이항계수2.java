package zm10d04;

import java.util.Scanner;

public class BJ_11051_이항계수2 {
	static final int mod = 10007;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		dp = new int[n+1][r+1];
		System.out.println(BC(n,r));
	}
	public static int BC(int n, int r) {
		if(dp[n][r]  > 0) {
			return dp[n][r];
		}
		if(n==r || r==0) return dp[n][r] = 1;
		
		return dp[n][r] = (BC(n-1,r-1) + BC(n-1,r)) % mod;
	}

}
