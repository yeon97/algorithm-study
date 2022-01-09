package month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 메모리 : 13815KB
 시  간 : 128ms
 */
public class Main_BJ_4963_섬의개수_0109 {

	static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int map[][], w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder res = new StringBuilder();

		w = -1; // 너비
		h = -1; // 높이

		// 종료 조건
		while (w != 0 && h != 0) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			// 지도
			map = new int[h][w];

			// 지도 채우기
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// dfs
			int cnt = 0; // 섬 개수
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						cnt++;
						dfs(i, j, map);
						
					}
				}
			}
			res.append(cnt + "\n");
		}
		
		// 0 0 인 값과 그 앞 뒤로 개행 제거
		res.setLength(res.length() - 3);
		
		System.out.println(res.toString());
	}

	private static void dfs(int x, int y, int[][] map) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] curQ = queue.poll();
			int curx = curQ[0];
			int cury = curQ[1];
			
			map[curx][cury] = -1;

			// 8방향 탐색
			for (int d = 0; d < 8; d++) {
				int nx = curx + dx[d];
				int ny = cury + dy[d];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] != 1)
					continue;

				queue.offer(new int[] {nx, ny});
				map[nx][ny] = -1;

			}
		}
		
	}

}
