package M01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2589_보물섬 {
	static int R,C, MAX;
	static boolean [][] field;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		field = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C; j++) {
				field[i][j] = str.charAt(j) == 'W' ? true:false;
			}
		}

		for(int i = 0; i < R; i++) {
			for(int j = 0 ; j < C; j++) {
				if(!field[i][j]) {
					bfs(new boolean[R][C], i, j);
				}
			}
		}
		
		System.out.println(MAX);
	}
	private static void bfs(boolean[][] visited, int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c,0});
		visited[r][c] = true;
		while(!que.isEmpty()) {
			int[] cool = que.poll();
			for(int d = 0 ; d < 4; d++) {
				int rr = cool[0] + dy[d];
				int cc = cool[1] + dx[d];
				if(rr < 0 || cc < 0 || rr >= R || cc >= C) continue;
				if(!visited[rr][cc] && !field[rr][cc]) {
					visited[rr][cc] = true;
					que.offer(new int[] {rr,cc, cool[2]+1});
					MAX = Math.max(MAX, cool[2]+1);
				}
			}
		}
	}
}
