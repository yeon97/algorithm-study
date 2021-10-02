package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 		메모리  11668KB		시간	92ms
 */
public class Main_BJ_2293_동전1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] dp = new int [k+1];
		int [] type = new int [n];
		
		for (int i = 0 ; i < n ; i++) {
			type[i] = Integer.parseInt(br.readLine());
		}
		
		
		dp[0] = 1;
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = type[i] ; j <= k ; j++) {
				dp[j] += dp[j-type[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
