package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
  메모리 : 106336 KB
  시간 : 536 ms 
*/
public class Main_BOJ_2573_빙산_1213 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(true) {
			int cnt = counting(map, N, M);
			if(cnt >= 2) break;
			else if(cnt == 0) {
				time = 0;
				break;
			}
			melting(map, N, M);
			time++;
		}
		System.out.println(time);
	}
	
	static int counting(int[][] map, int N, int M) {
		int cnt = 0;
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, visited, map, N, M);
					cnt++;
				}	
			}
		}
		return cnt;
	}
	
	static void dfs(int x, int y, boolean[][] visited, int[][] map, int N, int M) {
		visited[x][y] = true;
		for(int dir=0; dir<4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue;
			if(map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
				dfs(nextX, nextY, visited, map, N, M);
			}
		}
	}
	
	static void melting(int[][] map, int N, int M) {
		Queue<Ice> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					int cnt = 0;
					for(int dir=0; dir<4; dir++) {
						int nextX = i + dx[dir];
						int nextY = j + dy[dir];
						if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue;
						if(map[nextX][nextY] == 0) cnt++;
					}
					q.offer(new Ice(i, j, cnt));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Ice curr = q.poll();
			int x = curr.x;
			int y = curr.y;
			int cnt = curr.cnt;
			map[x][y] -= cnt;
			if(map[x][y] < 0) map[x][y] = 0;
		}
	}
	
	static class Ice {
		int x, y, cnt;
		public Ice(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
