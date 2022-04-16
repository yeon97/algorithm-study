package jinmyeong.Aug2021.algo0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		int [][] students = new int[7][2];
		
		for (int i = 0 ; i < students.length;i++) {
			Arrays.fill(students[i], 0);
		}
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			students[Y][S]++;
		}
		
		for (int i = 1; i < 7 ; i++) {
			for (int j = 0 ; j < 2 ; j++) {
				if (students[i][j]%K ==0) ans += students[i][j]/K;
				else ans += students[i][j]/K +1;
			}
		}
		System.out.println(ans);
	}
}
