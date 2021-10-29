package zm10d28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1937_욕심쟁이판다 {
	static int[][] visited;
	static int MAX, N;
	static int[] dy = new int[] {-1,1,0,0};
	static int[] dx = new int[] {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] field = new int[N][N];
		visited = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ;  j< N; j++) {
				field[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ;  j< N; j++) {
				if(visited[i][j] != 0)continue;
				MAX = Math.max(MAX, dfs(field,i,j));
			}
		}
		System.out.println(MAX);
	}
	public static int dfs(int[][] field, int r, int c) {
		if(visited[r][c] != 0) {
			return visited[r][c];
		}
		visited[r][c] = 1;
		for(int i = 0 ; i < 4; i++) {
			int mr = r +dy[i];
			int mc = c +dx[i];
			if(mr>=0 && mr < N && mc>=0 && mc < N ) {
				if(field[mr][mc] > field[r][c]) {
					
					visited[r][c] = Math.max(visited[r][c], dfs(field,mr,mc) + 1);
					
				}
			}
		}
		return visited[r][c];
	}

}
