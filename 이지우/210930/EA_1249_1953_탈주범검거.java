package om9d30;

import java.io.*;
import java.util.*;

public class EA_1249_1953_탈주범검거 {
	static int R,C,r,c,L;
	static int[][] field;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			field = new int[R][C];
			visit = new boolean[R][C];
			for(int i = 0 ; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < C; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			int cnt = 0;
			for(int i = 0 ; i < R; i++) {
				for(int j = 0 ; j < C; j++) {
					if(visit[i][j]) cnt++;
				}
			}
			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
	public static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c,field[r][c],1});
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int rr = tmp[0];
			int cc = tmp[1];
			int kk = tmp[2];
			int ll = tmp[3];
			if(ll > L) break;
			if(visit[rr][cc])continue;
			visit[rr][cc] = true;
			int[][] nextLV = conChoice(kk,rr,cc);
			
			for(int i = 0 ; i < nextLV.length; i++) {
				int rrr = nextLV[i][0];
				int ccc = nextLV[i][1];
				if(rrr < 0 || ccc < 0 || rrr >= R || ccc >= C || field[rrr][ccc] == 0)continue;
				int[][] canNext = conChoice(field[rrr][ccc],rrr,ccc);
				for(int j = 0 ; j < canNext.length; j++) {
					int rrrr = canNext[j][0];
					int cccc = canNext[j][1];
					if(rrrr==rr && cccc==cc) {
//						System.out.println("냐항!");
						que.add(new int[] {rrr,ccc,field[rrr][ccc],ll+1});
						break;
					}
				}
			}
		}
	}
	public static void canMove(int kk, int rr, int cc) {
		
		
		
	}
	public static void check() {
		
	}
	public static int[][] conChoice(int k, int r, int c){
		int[] dy = new int[] {-1,1,0,0};
		int[] dx = new int[] {0,0,-1,1};
		int[][] result;
		
		switch(k) {
		case 1 : result = new int[4][2];
				result[0][0] = r + dy[0]; result[0][1] = c + dx[0]; // 상
				result[1][0] = r + dy[1]; result[1][1] = c + dx[1]; // 하
				result[2][0] = r + dy[2]; result[2][1] = c + dx[2]; // 좌
				result[3][0] = r + dy[3]; result[3][1] = c + dx[3]; // 우
				break;
		case 2 : result = new int[2][2];
				result[0][0] = r + dy[0]; result[0][1] = c + dx[0]; // 상
				result[1][0] = r + dy[1]; result[1][1] = c + dx[1]; // 하
				break;
		case 3 : result = new int[2][2];
				result[0][0] = r + dy[2]; result[0][1] = c + dx[2]; // 좌
				result[1][0] = r + dy[3]; result[1][1] = c + dx[3]; // 우
				break;
		case 4 : result = new int[2][2];
				result[0][0] = r + dy[0]; result[0][1] = c + dx[0]; // 상
				result[1][0] = r + dy[3]; result[1][1] = c + dx[3]; // 우
				break;
		case 5 : result = new int[2][2];
				result[0][0] = r + dy[1]; result[0][1] = c + dx[1]; // 하
				result[1][0] = r + dy[3]; result[1][1] = c + dx[3]; // 우
				break;
		case 6 : result = new int[2][2];
				result[0][0] = r + dy[1]; result[0][1] = c + dx[1]; // 하
				result[1][0] = r + dy[2]; result[1][1] = c + dx[2]; // 좌
				break;
		default : result = new int[2][2];
				result[0][0] = r + dy[0]; result[0][1] = c + dx[0]; // 상
				result[1][0] = r + dy[2]; result[1][1] = c + dx[2]; // 좌
		}
		
		return result;
	}
}
