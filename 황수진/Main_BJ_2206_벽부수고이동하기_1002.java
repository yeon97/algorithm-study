import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 	메모리 138148KB
 	시간 576m
 */
public class Main_BJ_2206_벽부수고이동하기_1002 {
	
	static int N, M, arr[][], visited[][], res = 0;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		// visited : 벽을 부신 개수를 저장
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			Arrays.fill(visited[i], Integer.MAX_VALUE);
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();
		
		if(res == 0)
			System.out.println(-1);
		else
			System.out.println(res);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int []>();
		queue.offer(new int[] {0, 0, 1, 0}); // r, c, 이동횟수, 공사횟수
		visited[0][0] = 0; // 공사 횟수 저장

		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int move = cur[2];
			int wall = cur[3];
			
			// 목적지 도착
			if(r == N - 1 && c == M - 1) {
				 res = move;
				 break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dx[d];
				int nc = c + dy[d];
				
				// 배열 범위 체크
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				// 방문했었으면 0 이나 1이기 때문에
				if(visited[nr][nc] <= wall) 
					continue;
				
				if(arr[nr][nc] == 0) { // 벽이 아닌 곳
					visited[nr][nc] = wall;
					queue.offer(new int[] {nr, nc, move + 1, wall});
				}
				else { // 벽인 곳
					if(wall == 0) {
						visited[nr][nc] = wall + 1;
						queue.offer(new int[] {nr, nc, move + 1, wall + 1});
					}
				}
			}
		}
	}
}