import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 메모리 : 708144KB
 시  간 : 1352ms
 */

public class S1_Main_BJ_16928_뱀과사다리게임_0306 {
	
	static int[] map = new int[101]; // 뱀, 사다리가 있는 게임 판
	static boolean[] visited = new boolean[101]; // 방문체크용
	static int res = 0; // 결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 값 입력
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		BFS(1);
		
		// 결과 출력
		System.out.println(res);
	}

	private static void BFS(int i) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int p = cur[0]; // 지금 위치
			int c = cur[1]; // 지금까지 이동한 횟수

			visited[p] = true; // 방문 체크
			
			if(p == 100) {
				res = c;
				return;
			}
			 
			// 주사위 돌리기
			for (int j = 1; j <= 6; j++) {
				int next = p + j;
				if(next > 100 || visited[next]) continue;
				
				// 이동한 위치에 뱀이나 사다리가 있는 경우 그 위치로 이동
				if(map[next] != 0) 
					queue.add(new int[] {map[next], c + 1});
				else 
					queue.add(new int[] {next, c + 1});
			}
		}
	}
}
