package algo_220305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_2667_단지번호붙이기 {
	
	static boolean [][] visited;
	static int [][] map;
	static int [][] D = {{0, -1},{0, 1},{-1, 0},{1, 0}};
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for (int j = 0 ; j < str.length() ; j++) {
				map[i][j] = str.charAt(j)- '0';
			}
		}
		
		visited = new boolean[N][N];
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if (map[i][j] == 0 || visited[i][j]) continue;
				cnt.add(split(i, j));
			}
		}
		
		System.out.println(cnt.size());
		Collections.sort(cnt);
		for (int c : cnt) {
			System.out.println(c);
		}
	}
	
	static int split(int x, int y) {

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int [] {x, y});
		visited[x][y] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int [] now = queue.poll();
			cnt++;
			
			for (int d = 0 ; d < 4 ; d++) {
				int nx = now[0] + D[d][0];
				int ny = now[1] + D[d][1];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 0) continue;
				queue.offer(new int [] {nx, ny});
				visited[nx][ny] = true;
			}
			
		}
		
		return cnt;
	}
}


