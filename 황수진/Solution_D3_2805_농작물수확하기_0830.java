import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_2805_농작물수확하기_0830 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int [][]arr = new int[N][N];
			
			int s = N/2;
			int e = N/2;
			int res = 0;
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = (int)(str.charAt(j) - '0');
				}
			}
		
			
			for(int i = 0; i < N/2; i++) {
				for(int j = s; j <= e; j++) {
					res += arr[i][j];
				}
				s--;
				e++;
			}
			
			for(int i = N/2; i < N; i++) {
				for(int j = s; j <= e; j++) 
					res += arr[i][j];
				s++;
				e--;
			}

			System.out.println("#" + t + " " + res);
		} // testcase
		
	} // main

}
