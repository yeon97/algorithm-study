package jinmyeong.Aug2021.algo0827;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_7236_저수지의물의총깊이구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } }; // 가운데 기준 왼쪽위부터 시계방향 한바퀴

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			char[][] map = new char[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = 0;
					if (map[i][j] != 'W') continue;
					for(int k = 0 ; k < 8; k++) {
						int nx = i+d[k][0];
						int ny = j+d[k][1];
						if (nx < 0 || ny <0 || nx >= N || ny >= N) continue;
						if(map[nx][ny] == 'W') temp += 1;
					}
					if (temp == 0) temp = 1;
					if (temp > ans) ans = temp;
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		
		}
		System.out.println(sb);

	}
}
