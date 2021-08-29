package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_D3_7236_저수지의물의총깊이구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int[][] d = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		
		
		for(int tc=1; tc<=testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			ArrayList<Water> water = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if(map[i][j] == 'W') water.add(new Water(i, j));
				}
			} // map 초기화
			
			int max = 1;
			
			for(int i=0; i<water.size(); i++) {
				Water current = water.get(i);
				int x = current.x;
				int y = current.y;
				int currCnt = 0;
				for(int dir=0; dir<8; dir++) {
					int nextX = x+d[dir][0];
					int nextY = y+d[dir][1];
					if(nextX < 0 || nextX>=N || nextY<0 || nextY>=N) continue;
					if(map[nextX][nextY] == 'W') currCnt++;
				}
				max = (currCnt > max) ? currCnt: max;
			}
			System.out.println("#" + tc + " " + max);
			
		}
	}
	static class Water {
		int x;
		int y;
		public Water(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
