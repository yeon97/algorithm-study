package zm11d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_7579_앱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = null;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] apps = new int[N+1][2];
		int[][] setM = new int[N+1][10001];
		
		st = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			apps[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken())};
		}
		for(int i = 1 ; i <= N; i++) {
			int memory = apps[i][0];
			int cost = apps[i][1];
			for(int j = 0; j <= 10000; j++) {
				if(cost > j) {
					setM[i][j] = setM[i-1][j];
				}else {
					setM[i][j] = Math.max(setM[i-1][j-cost] + memory, setM[i-1][j]);
				}
			}
		}
		for(int j = 0; j <= 10000; j++) {
			if(setM[N][j] >= M) {
				System.out.println(j);
				return;
			}
		}
	}

}
