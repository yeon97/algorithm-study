package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_D3_5215_햄버거다이어트_DP_0914 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] score = new int[N+1];
			int[] kcal = new int[N+1]; 
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] D = new int[2][L+1];
			
			for(int i=1; i<=N; i++) {
				for(int k=1; k<=L; k++) {
					if(kcal[i] <= k) {
						D[i%2][k] = Math.max(D[(i-1)%2][k], score[i] + D[(i-1)%2][k-kcal[i]]);
					} else {
						D[i%2][k] = D[(i-1)%2][k];
					}
				}
			}
			if(N%2 == 0) {
				D[1][L] = D[0][L];
			}
			System.out.println("#"+ tc + " " + D[1][L]);
			
//			int[][] D = new int[N+1][L+1];
//			
//			for(int i=1; i<=N; i++) {
//				for(int k=1; k<=L; k++) {
//					if(kcal[i] <= k) {
//						D[i][k] = Math.max(D[i-1][k], score[i]+D[i-1][k-kcal[i]]);
//					} else {
//						D[i][k] = D[i-1][k];
//					}
//				}
//			}
//			System.out.println("#"+ tc + " " + D[N][L]);
		} 
	}
}


/*

1
5 1000
100 200
300 500
250 300
500 1000
400 400

 */