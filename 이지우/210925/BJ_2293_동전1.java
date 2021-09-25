package om9d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2293_동전1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] don = new int[N];
		for(int i = 0 ; i < N; i++) {
			don[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[K+1];
		for(int i = 0 ; i < N; i ++) {
			for(int k =1; k < K+1; k++) {
				if(k == don[i]) {
					dp[k]++;
				}
				if(k > don[i]) {
					dp[k] += dp[k-don[i]]; 
				}
			}
		}
		System.out.println(dp[K]);
	}
}
