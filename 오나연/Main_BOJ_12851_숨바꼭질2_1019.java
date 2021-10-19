package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
  메모리 : 23972 KB
  시간 : 128 ms
*/

public class Main_BOJ_12851_숨바꼭질2_1019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N >= K) {
			System.out.println(N-K);
			System.out.println(1);
		} else {
			int[] current = bfs(N, K);
			System.out.println(current[0]);
			System.out.println(current[1]);
		}
	}
	
	private static int[] bfs(int N, int K) {
		Queue<int[]> q = new LinkedList<>();
		int[] visited = new int[100001];
		
		q.offer(new int[] {N, 0});
		visited[N] = 1;
		
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int pos = cur[0];
			int time = cur[1];
			int[] next = {pos+1, pos-1, pos*2};
			
			if(time >= min) return new int[] {min, cnt};
			
			for(int i=0; i<3; i++) {
				if(next[i] == K && time+1 <= min) {
					min = time+1;
					cnt++;
				} else if(next[i] <= 100000 && next[i] >= 0 && (visited[next[i]]==0 || visited[next[i]] == time+1)) {
					q.offer(new int[] {next[i], time+1});
					visited[next[i]] = time+1;
				}				
			}
		}
		return new int[] {min, cnt};
	}
}