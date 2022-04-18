package M01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11049_행렬곱셈순서 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] mtr = new int[N+1][2];
		int[][] dp = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			mtr[i][0] = Integer.parseInt(st.nextToken());
			mtr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++ ) {
			for(int j = 1; j+i <= N; j++) {
				dp[j][j+i] = Integer.MAX_VALUE;
				for(int k = j; k < i+j; k++) {
					dp[j][i+j] = Math.min(dp[j][i+j], 
							dp[j][k] + dp[k+1][i+j] 
							+ mtr[j][0]*mtr[k][1]*mtr[i+j][1]);
				}
			}
		}
		
		System.out.println(dp[1][N]);
	}

}
