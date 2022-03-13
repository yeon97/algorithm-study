package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 메모리 : 11716 KB
 시간 : 96 ms
*/
public class Main_BOJ_2667_단지번호붙이기_0313 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		List<Integer> list = new ArrayList<>(); 
		
		for(int i=0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;				
				// 1이면 아파트
				if(map[i][j] == 1) {
					visited[i][j] = true;
					list.add(find(i, j, map, visited, N));
				}
			}
		}		
		Collections.sort(list);
		int size = list.size();
		System.out.println(size);
		for(int i=0; i<size; i++) {
			System.out.println(list.get(i));
		}		
	}
	
	// 아파트 단지 찾기
	public static int find(int x, int y, int[][] map, boolean[][] visited, int N) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			cnt++;
			
			for(int dir=0; dir<4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;				
				if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
				visited[nextX][nextY] = true;
				q.offer(new int[] {nextX, nextY});
			}			
		}		
		return cnt;
	}
}