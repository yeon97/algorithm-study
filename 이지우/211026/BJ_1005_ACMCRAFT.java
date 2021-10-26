package zm10d26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1005_ACMCRAFT {
	static int N,K,W;
	static int[] times,answer;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ;  t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			graph = new int[N+1][N+1];
			times = new int[N+1];
			answer = new int[N+1];
			visited = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				times[i] = tmp;
				answer[i] = tmp;
			}
			for(int i = 0 ; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			W = Integer.parseInt(br.readLine());
			System.out.println(build());
			/*
			 1 2
			1 3
			2 4
			3 4
			
				0110
				0001
				0001
				0000
			 */
		}
	}
	public static  int build() {
		while(true) {
			List<Integer> arr = canStart();
			if(arr.size() != 0) {
				for(int i = 0 ; i < arr.size(); i++) {
					int x = arr.get(i);
					if(x == W) return answer[W];
					visited[x] = true;
					for(int j = 1; j <= N; j++) {
						if(graph[x][j] == 1) {
							graph[x][j] = 0;
							answer[j] = Math.max(answer[j], times[j] + answer[x]);
						}
					}
				}
			}
			
			else break;
		}
		return -1;
	}
	public static List<Integer> canStart() {
		List<Integer> arr = new ArrayList<>();
		for(int i = 1 ; i <= N; i++) {
			if(visited[i]) continue;
			boolean check = true;
			for(int j = 1; j <= N; j++) {
				if(graph[j][i] == 1) {
					check = false;
					break;
				}
			}
			if(check) {
				arr.add(i);
			}
		}
		return arr;
	}

}
