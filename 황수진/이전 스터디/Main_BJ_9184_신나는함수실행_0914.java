import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * a | b | c <= 0 -> 1
 * a, b, c > 20   -> w(20, 20, 20)
 * a < b < c 	  -> w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
 * 	 else	      -> w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
 					
 */
public class Main_BJ_9184_신나는함수실행_0914 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1)
				break;
			System.out.println("w(" + a +", " + b + ", " + c + ") = " + w(a, b, c));
		}
	}

	private static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0)
			return 1;
		
		if(a > 20 || b > 20 || c > 20) {
			a = 20;
			b = 20;
			c = 20;
		}
		
		int dp[][][] = new int[a+1][b+1][c+1];
		
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int j2 = 0; j2 <= c; j2++) {
					if(i <= 0 || j <= 0 || j2 <= 0)
						dp[i][j][j2] = 1;
					else if(i < j && j < j2)
						dp[i][j][j2] = dp[i][j][j2-1] + dp[i][j-1][j2-1] - dp[i][j-1][j2];
					else
						dp[i][j][j2] = dp[i-1][j][j2] + dp[i-1][j-1][j2] + dp[i-1][j][j2-1] - dp[i-1][j-1][j2-1];
				}
			}
		}
		return dp[a][b][c];
	}
}
