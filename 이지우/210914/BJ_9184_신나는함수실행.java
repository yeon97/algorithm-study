package om9d14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_9184_신나는함수실행 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int dp[][][] = new int [21][21][21];;
		for(int x = 0 ; x <= 20; x++) {
			for(int y = 0 ; y <= 20; y++) {
				for(int z = 0 ; z <= 20; z++) {
					if(x <= 0 || y <= 0 || z <= 0 ) {
						dp[x][y][z] = 1;
					}else if(x < y && y < z) {
						dp[x][y][z] = dp[x][y][z-1] + dp[x][y-1][z-1] - dp[x][y-1][z];
					}else {
						dp[x][y][z] = dp[x-1][y][z] + dp[x-1][y-1][z] + dp[x-1][y][z-1] - dp[x-1][y-1][z-1];
					}
				}
			}
		}
		while(true) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int ans = 0;
			if(a==-1 && b==-1 && c==-1)break;
			if (a <= 0 || b <= 0 || c <= 0) {
				ans = 1;
			}else if (a > 20 || b > 20 || c > 20) {
				ans = dp[20][20][20];
			}else {
				ans = dp[a][b][c];
			}
			sb.append("w("+a+", "+b+", "+c+") = "+ans+"\n");
		}
		System.out.println(sb);
	}
	

}
