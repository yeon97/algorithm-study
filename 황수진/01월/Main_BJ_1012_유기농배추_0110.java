package month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 메모리 : 13620KB
 시  간 : 116ms
 */
public class Main_BJ_1012_유기농배추_0110 {
	
	static int farm[][], M, N;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			farm = new int[M][N];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				farm[x][y] = 1;
			}
			
			int res = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(farm[i][j] == 1) {
						res++;
						bfs(i, j, farm);
					}
				}
			}
			sb.append(res + "\n");
		} // end while
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void bfs(int x, int y, int[][] farm) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			farm[curX][curY] = -1;
			
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || farm[nx][ny] != 1) 
					continue;
				
				farm[nx][ny] = -1;
				queue.offer(new int[] {nx, ny});
				
			}
		}
	}

}
