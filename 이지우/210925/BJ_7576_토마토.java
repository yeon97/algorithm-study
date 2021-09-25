package om9d24;

import java.io.*;
import java.util.*;

public class BJ_7576_토마토 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] field = new int[R][C];
		for(int i = 0; i < R; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs(field,R,C));
	}
	public static int bfs(int[][] field, int R, int C) {
		int[] dY = new int[] {-1,0,1,0};
		int[] dX = new int[] {0,1,0,-1};
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> que = new LinkedList<int[]>();
		for(int i = 0 ; i < R; i ++) {
			for(int j = 0; j < C; j++) {
				if(field[i][j] == 1) {
					que.offer(new int[] {i,j,0});
				}
				if(field[i][j] != 0) {
					visited[i][j] = true;
				}
			}
		}
		int tmp = 0;
		while(!que.isEmpty()) {
			int[] po = que.poll();
			for(int i = 0; i < 4; i++) {
				int yy = po[0] + dY[i];
				int xx = po[1] + dX[i];
				if(yy<0 || xx < 0 || yy >= R || xx >= C || visited[yy][xx])continue;
				visited[yy][xx] = true;
				tmp = po[2]+1;
				que.offer(new int[] {yy,xx,tmp});
			}
		}
		for(int i = 0 ; i < R; i ++) {
			for(int j = 0; j < C; j++) {
				if(!visited[i][j]) tmp = -1;
			}
		}
		
		return tmp;
	}

}
