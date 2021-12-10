package algo211209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 	mem: 279496KB	time: 728ms
 */

public class Main_BJ_2573_빙산 {

	static int N, M;
	static int[][] map;
	static int[][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		
		while(true) {
			ans++;
			thaw();
			
			if (checkSplit() == 0) {
				ans = 0;
				break;
			} else if (checkSplit() == 2) {
				break;
			}
		}
		
		System.out.println(ans);

	}
	static void thaw() {
		int [][] temp = new int[N][M];
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if (map[i][j] == 0) continue;
				// 일단 해당 지점 얼음의 크기를 새로운 배열에 저장
				temp[i][j] = map[i][j];
				for (int d = 0 ; d < 4 ; d++) {
					int nx = i + D[d][0];
					int ny = j + D[d][1];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					
					// 만약 상하좌우에 물이 있다면? 해당 값을 -1 해
					if (map[nx][ny] == 0) {
						temp[i][j]--;
					}
				}
				// 다 돌았을 때 기존 빙하의 크기가 주변 물에 닿은 부분보다 값이 작아 -가 되었다면 0으로 돌려줌
				if (temp[i][j] < 0) temp[i][j] = 0;
			}
		}
		
		// 여기 까지 왔다면 각 빙하가 물에 닿은 면적 만큼 값이 깎임
		
		// debug start
//		for (int i = 0 ; i < N ; i++) {
//			for (int j = 0 ; j < M ; j++) {
//				System.out.print(temp[i][j]);
//			}
//			System.out.println();
//		}
		// debug end
		
		// 기존의 배열을 새로 업데이트 한 값으로 바꿔줌
		map = temp;
	}
	
	// 2차원 배열 전체의 값을 모두 더하고 한 지점에서 bfs로 탐색하면서 더한 값과 비교하여
	// 동일한 값이 나오면 하나의 섬(return 1) 그렇지 않으면 두개 이상의 섬(return 2)으로 갈라졌다고 판단한다.
	// 혹시 total 값이 0이라면 전부 녹아 빙산이 없어진 것이므로 0을 반환하여 알려준다.
	static int checkSplit() {
		boolean [][] visited = new boolean[N][M];
		
		int total = 0;
		int init_x = -1;
		int init_y = -1;
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if (init_x == -1 && init_y == -1 && map[i][j] != 0) {
					init_x = i;
					init_y = j;
				}
				total += map[i][j];
			}
		}
		
		if (total == 0) return 0;
		
		int cnt = 0;
		
		Queue<int []> queue = new LinkedList<>();
		queue.offer(new int [] {init_x, init_y});
		visited[init_x][init_y] = true;
		cnt += map[init_x][init_y];
		
		while (!queue.isEmpty()) {
			int [] now = queue.poll();
			
			for (int d = 0 ; d < 4 ; d++) {
				int nx = now[0] + D[d][0];
				int ny = now[1] + D[d][1];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;
				
				visited[nx][ny] = true;
				queue.offer(new int [] {nx, ny});
				cnt += map[nx][ny];
			}
		}
		
//		System.out.println("total >>> "+total+" cnt >>> "+cnt);
		
		if (total == cnt) {
			return 1;
		} else {
			return 2;
		}
	}
}
