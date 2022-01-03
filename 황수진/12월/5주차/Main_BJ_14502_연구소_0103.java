package month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 메모리 : 295652KB
 시  간 : 672ms
 */

public class Main_BJ_14502_연구소_0103 {

	static int N, M, map[][], copy[][], res = 0;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copy = new int[N][M];

		// 데이터 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 벽 3가지 고르기 + 안전지대 세기
		combination(0);

		System.out.println(res);
	}

	// 벽 세우는 조합
	private static void combination(int cnt) {
		// 벽 3개 다 세우기
		if (cnt == 3) {
			// 안전영역 세기
			countArea();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 0인 곳에 벽 세워보기
				if (map[i][j] == 0) {
					map[i][j] = 1;

					combination(cnt + 1);

					// 다시 벽 없애기
					map[i][j] = 0;
				}
			}
		}
	}

	// 안전지대 세기
	private static void countArea() {
		Queue<int[]> queue = new LinkedList<>();
		copyMap();

		// 바이러스 위치 offer
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 2)
					queue.offer(new int[] { i, j });
			}
		}

		// 바이러스 퍼트리기
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();

			int curX = cur[0];
			int curY = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];

				// 배열 범위 넘어가면 continue
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				// 빈 칸이면 바이러스 확산
				if (copy[nx][ny] == 0) {
					copy[nx][ny] = 2;
					queue.offer(new int[] { nx, ny });
				}
			}
		}

		// 안전지대 세기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0)
					cnt++;
			}
		}

		res = Math.max(res, cnt);
	}
	
	// 배열 복사
	private static void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

}
