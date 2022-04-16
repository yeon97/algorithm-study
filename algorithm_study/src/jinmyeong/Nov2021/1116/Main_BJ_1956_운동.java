import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 		2021. 11. 16
 * 		mem : 57924KB	time : 576ms
 */

public class Main_BJ_1956_운동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int INF = 987654321;
		
		int V, E;
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int [][] map;
		map = new int [V+1][V+1];
		
		for (int i = 1 ; i <= V ; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 1 ; k <=V ; k++) {
			for (int i = 1 ; i <= V ; i++) {
				if (i == k) continue;
				for (int j = 1 ; j <= V ; j++) {
					if (j == k) continue;
					if (map[i][k]+map[k][j] < map[i][j]) map[i][j] = map[i][k]+map[k][j];
				}
			}
		}
		int ans = INF;
		for (int i = 1 ; i <= V ; i++) {
			if(map[i][i] < ans) ans = map[i][i];
		}
		ans = ans==INF?-1:ans;
		
		System.out.println(ans);
	}
}
