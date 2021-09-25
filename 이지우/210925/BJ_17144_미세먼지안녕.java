package om9d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] field = new int[R][C];
		for(int i = 0; i < R; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tmp = 0;
		for(int i = 2 ; i < R-2; i++) {
			if(field[i][0] == -1) {
				tmp = i;
				break;
			}
		}
		int[] up = new int[] {tmp,0};
		int[] down = new int[] {tmp+1,0};
		for (int t = 0 ; t < T; t ++) {
			diffusion(field, R, C);
			purityUp(field, R, C, up);
			purityDown(field, R, C, down);
		}
		int sum = 0;
		for(int i = 0; i < R; i ++) {
			for(int j = 0; j < C; j++) {
				if(field[i][j] > 0) {
					sum += field[i][j];
				}
			}
		}
		System.out.println(sum);
	}
	public static void diffusion(int[][] field, int R, int C) {
		Queue<int[]> que = new LinkedList<int[]>();
		int[] dY = new int[] {-1,0,1,0};
		int[] dX = new int[] {0,1,0,-1};
		for(int i = 0 ; i < R; i ++) {
			for(int j = 0 ; j < C; j ++) {
				if(field[i][j] > 0) {
					que.add(new int[] {i,j, field[i][j]});
				}
			}
		}
		while(!que.isEmpty()) {
			int[] po = que.poll();
			int cnt = 0;
			int mungi = po[2];
			for(int d = 0 ; d < 4; d++) {
				int yy = po[0] + dY[d];
				int xx = po[1] + dX[d];
				if(yy<0 || xx < 0 || yy >= R || xx >= C || field[yy][xx] == -1 )continue;
				cnt++;
				field[yy][xx] += mungi/5;
			}
			field[po[0]][po[1]] -= (mungi/5)*cnt;
			
		}
		
	}// diffusion함수 끝
	public static void purityUp(int[][] field, int R, int C, int[] up) {
//		for(int i = up[0], j = 0; ;) {
//			if(j == 0) {
//				
//			}
//			if(i == 0) {
//				
//			}
//		}
		int i = up[0];
		int max = up[0];
		int j = 0;
		while(true) {
			if(i-1 == 0) {
				field[i-1][0] = field[i-1][1];
				break;
			}
			field[i-1][0] = field[i-2][0];
			i--;
		}
		while(true) {
			if(j+1 == C-1) {
				field[0][j+1] = field[1][j+1];
				break;
			}
			field[0][j+1] = field[0][j+2];
			j++;
		}
		while(true) {
			if(i == max) {
				field[i][C-1] = field[i][j];
				break;
			}
			field[i][C-1] = field[i+1][C-1];
			i++;
		}
		while(true) {
			if(j == 1) {
				field[max][j] = 0;
				break;
			}
			field[max][j] = field[max][j-1];
			j--;
		}
	}
	public static void purityDown(int[][] field, int R, int C, int[] down) {
//		for(int i = up[0], j = 0; ;) {
//			if(j == 0) {
//				
//			}
//			if(i == 0) {
//				
//			}
//		}
		int i = down[0];
		int min = down[0];
		int j = 0;
		while(true) {
			if(i+1 == R-1) {
				field[i+1][0] = field[i+1][1];
				break;
			}
			field[i+1][0] = field[i+2][0];
			i++;
		}
		while(true) {
			if(j+1 == C-1) {
				field[R-1][j+1] = field[R-2][j+1];
				break;
			}
			field[R-1][j+1] = field[R-1][j+2];
			j++;
		}
		while(true) {
			if(i+1 == min) {
				field[min][C-1] = field[min][j];
				break;
			}
			field[i+1][C-1] = field[i][C-1];
			i--;
		}
		while(true) {
			if(j == 1) {
				field[min][j] = 0;
				break;
			}
			field[min][j] = field[min][j-1];
			j--;
		}
	}
}

