import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트_0914 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			str = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(str.nextToken());
			int L = Integer.parseInt(str.nextToken());
			
			int taste[] = new int[N + 1];
			int cal[] = new int[N + 1];
			
			for (int i = 1; i <= N ; i++) {
				str = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(str.nextToken());
				cal[i] = Integer.parseInt(str.nextToken());
			}
			
			int res[][] = new int[N+1][L+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= L; j++) {
					if(cal[i] <= j) {
						res[i][j] = Math.max(res[i-1][j], taste[i] + res[i-1][j-cal[i]]); 
					}
					else {
						res[i][j] = res[i-1][j];
					}
				}
			}
			System.out.println("#" + t + " " + res[N][L]);
		}
	}
}
