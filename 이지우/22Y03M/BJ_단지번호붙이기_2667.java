package M01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ_단지번호붙이기_2667 {
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int N, cnt;
	static ArrayList<Integer> ans = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] field = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N; j++) {
				field[i][j] = str.charAt(j)-'0';
			}
		}
		ans = new ArrayList<>();
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(field[i][j] == 1) {
					cnt = 0;
					dfs(field,i,j);
					ans.add(cnt);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i = 0 ; i < ans.size(); i ++) {
			System.out.println(ans.get(i));
		}
	}
	private static void dfs(int[][] field, int y, int x) {
		cnt++;
		field[y][x] = 0;
		for(int d = 0 ; d < 4; d++) {
			int yy = dy[d]+y;
			int xx = dx[d]+x;
			if(yy<0||xx<0||yy>=N||xx>=N)continue;
			if(field[yy][xx] == 1) {
				dfs(field,yy,xx);
			}
		}
	}
}
