package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 		메모리 : 175332KB		시간 : 824ms
 */

public class Main_BJ_2206_벽부수고이동하기 {
	static class Pos {
		int x, y;
		boolean b;

		public Pos(int x, int y, boolean b) {
			super();
			this.x = x;
			this.y = y;
			this.b = b;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		final int INF = 987654321;
		
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] map;
		map = new int[N+1][M+1];
		
		boolean [][][] visited;
		visited = new boolean[N+1][M+1][2];
		int [][][] dist;
		dist = new int [N+1][M+1][2];
		
		for (int i = 1 ; i <= N ; i++) {
			for (int j = 1 ; j <= M ; j++) {
				Arrays.fill(dist[i][j], INF);
			}
		}
		
		for (int i = 1 ; i <= N ; i++) {
			String str = br.readLine();
			for (int j = 1 ; j <= M ;j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(1,1,false));
		visited[1][1][0] = true;
		dist[1][1][0] = 1;
		
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			int x = now.x;
			int y = now.y;
			boolean b = now.b;
			
			for (int d = 0 ; d < 4 ; d++) {
				int nx = x + D[d][0];
				int ny = y + D[d][1];
				
				if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
				
				// 벽을 부순 적이 있으면서 앞이 벽으로 막혀있는 경우
				if (b && map[nx][ny] == 1) continue; 
				// 벽을 부순 적이 있으면서 앞이 길인 경우, 방문한 적이 없거나 경로가 짧은 경우
				else if (b && (!visited[nx][ny][1] || dist[nx][ny][1] > dist[x][y][1] + 1)) {
					dist[nx][ny][1] = dist[x][y][1]+1;
					visited[nx][ny][1] = true;
					queue.offer(new Pos(nx, ny, true));
				}
				// 벽을 부순 적이 없으면서 앞이 벽인 경우, 벽을 부순적이 없으므로 반드시 처음 방문 한 곳
				else if (!b && map[nx][ny]==1) {
					dist[nx][ny][1] = dist[x][y][0]+1;
					visited[nx][ny][1] = true;
					queue.offer(new Pos(nx, ny, true));
				}
				// 벽을 부순 적이 없으면서 앞이 길인 경우, 방문한 적이 없거나 경로가 짧은 경우
				else if (!b && (!visited[nx][ny][0] || dist[nx][ny][0] > dist[x][y][0] + 1)){
					dist[nx][ny][0] = dist[x][y][0]+1;
					visited[nx][ny][0] = true;
					queue.offer(new Pos(nx, ny, false));
				}
			}
		}
		int ans = Math.min(dist[N][M][0], dist[N][M][1]);
		
		if (ans == INF) ans = -1;
		
		System.out.println(ans);
		
	}
}
