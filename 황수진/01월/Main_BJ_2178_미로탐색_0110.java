package month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 메모리 : 12244KB
 시  간 : 96ms 
 */

public class Main_BJ_2178_미로탐색_0110 {

	static int maze[][], N, M;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M]; // 미로
		visited = new boolean[N][M]; // 방문 체크
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs(0, 0, maze);
		
		System.out.println(maze[N - 1][M - 1]);
	}

	private static void bfs(int x, int y, int[][] maze) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			visited[curX][curY] = true;
			
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || maze[nx][ny] == 0 || visited[nx][ny])
					continue;
				
				visited[nx][ny] = true;
				maze[nx][ny] = maze[curX][curY] + 1;
				queue.offer(new int[] {nx, ny});
			}
		} // end while
	}
}
