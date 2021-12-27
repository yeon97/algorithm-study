package month12;

import java.util.Arrays;
import java.util.Scanner;

/*
 메모리 : 13624KB
 시  간 : 168ms
 */

public class Main_BJ_1405_미친로봇_1227 {
	
					// E, W, S, N
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static int n;
	static boolean[][] visited;
	static double prob[], res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		res = 0;
		
		// 동서남북 확률
		double E = sc.nextInt() * 0.01;
		double W = sc.nextInt() * 0.01;
		double S = sc.nextInt() * 0.01;
		double N = sc.nextInt() * 0.01;
		
		// 확률 저장
		prob = new double[] {E, W, S, N};
		
		// 방문체크용 배열
		visited = new boolean[30][30];
		// 시작점 방문 체크
		visited[15][15] = true;
		
		// DFS
		DFS(0, 15, 15, 1, visited);
		
		System.out.println(res);
	}

	private static void DFS(int cnt, int x, int y, double p, boolean[][] visited) {
		// n번 행동하면 종료
		if(cnt == n) {
			res += p;
			return;
		}
		
		// 4방향 탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			// 방문하지 않았고 범위 안에 있을때
			if(!visited[nx][ny] && 0 <= nx && nx < 30 && 0 <= ny && ny < 30) {
				// 방문 체크
				visited[nx][ny] = true;
				
				DFS(cnt + 1, nx, ny, p * prob[d], visited);
				
				// 방문 체크 해제
				visited[nx][ny] = false;
			}
		}
	}

}
