import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 메모리 : 11796KB
 시  간 : 104ms
 */
public class S1_Main_BJ_2667_단지번호붙이기_0305 {

	static int N;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 데이터 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		// 단지에 속하는 집의 수 저장
		ArrayList<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1)
					res.add(BFS(i, j));
			}
		}
		
		// 결과 출력
		System.out.println(res.size());
		Collections.sort(res);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		
	}

	// BFS
	private static int BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i, j});
		
		// 집 수
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			cnt++;
			// 체크한 곳은 0으로 
			map[x][y] = 0;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				// 범위 체크
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 0)
					continue;
				
				queue.offer(new int[] {nx, ny});
				map[nx][ny] = 0;
			}
		}
		
		return cnt;
	}
}
