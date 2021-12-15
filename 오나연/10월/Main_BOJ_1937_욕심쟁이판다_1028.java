package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 메모리 : 40488 KB
 시간 : 384ms
*/
public class Main_BOJ_1937_욕심쟁이판다_1028 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] D = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(D[i][j] == 0) dfs(i, j, map, N, D);
				if(D[i][j] > cnt) cnt = D[i][j];
			}
		}
		System.out.println(cnt);
	}
	
	private static void dfs(int x, int y, int[][] map, int N, int[][] D) {
		D[x][y] = 1;
		for(int dir=0; dir<4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			
			if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
			if(map[nextX][nextY] <= map[x][y]) continue;
			if(D[nextX][nextY] == 0) dfs(nextX, nextY, map, N, D);
			if(D[x][y] < D[nextX][nextY] + 1) D[x][y] = D[nextX][nextY] + 1;
		}
	}
}