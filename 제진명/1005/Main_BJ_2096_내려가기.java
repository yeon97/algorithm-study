package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		메모리 : 47060 KB		시간 : 376ms
 */

public class Main_BJ_2096_내려가기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] min_dp = new int [N][3];
		int [][] max_dp = new int [N][3];
		
		st = new StringTokenizer(br.readLine());
		
		max_dp[0][0] = min_dp[0][0] = Integer.parseInt(st.nextToken());
		max_dp[0][1] = min_dp[0][1] = Integer.parseInt(st.nextToken());
		max_dp[0][2] = min_dp[0][2] = Integer.parseInt(st.nextToken());
		
		for (int i = 1 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			max_dp[i][0] = Math.max(max_dp[i-1][0]+a, max_dp[i-1][1]+a);
			min_dp[i][0] = Math.min(min_dp[i-1][0]+a, min_dp[i-1][1]+a);
			if (max_dp[i-1][0]>max_dp[i-1][1]) {
				max_dp[i][1] = Math.max(max_dp[i-1][0]+b, max_dp[i-1][2]+b);
			} else {
				max_dp[i][1] = Math.max(max_dp[i-1][1]+b, max_dp[i-1][2]+b);
			}
			if (min_dp[i-1][0]>min_dp[i-1][1]){
				min_dp[i][1] = Math.min(min_dp[i-1][1]+b, min_dp[i-1][2]+b);
			} else {
				min_dp[i][1] = Math.min(min_dp[i-1][0]+b, min_dp[i-1][2]+b);
			}
			max_dp[i][2] = Math.max(max_dp[i-1][2]+c, max_dp[i-1][1]+c);
			min_dp[i][2] = Math.min(min_dp[i-1][2]+c, min_dp[i-1][1]+c);
			
		}
		
		int max = 0, min = 0;
		
		if (max_dp[N-1][0]>max_dp[N-1][1]) {
			max = Math.max(max_dp[N-1][0], max_dp[N-1][2]);
		} else {
			max = Math.max(max_dp[N-1][1], max_dp[N-1][2]);
		}
		if (min_dp[N-1][0]>min_dp[N-1][1]) {
			min = Math.min(min_dp[N-1][1], min_dp[N-1][2]);
		} else {
			min = Math.min(min_dp[N-1][0], min_dp[N-1][2]);
		}
		
		System.out.println(max +" "+min);
	}
}
