package M01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16928_뱀과사다리게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100];
		int[][] up = new int[N][2];
		int[][] down = new int[M][2];
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			up[i][0] = Integer.parseInt(st.nextToken()); 
			up[i][1] = Integer.parseInt(st.nextToken()); 
		}
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			down[i][0] = Integer.parseInt(st.nextToken()); 
			down[i][1] = Integer.parseInt(st.nextToken()); 
		}
		PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)->{  if(o1[1] == o2[1])return o1[0]-o2[0];
																	else return o1[1] - o2[1];
																});
		que.add(new int[] {1,0});
		visited[1] = true;
		loop:
		while(true) {
			int[] loc = que.poll();
			loop2:
			for(int n = 1; n <= 6; n++) {
				int x = loc[0] + n;
				if(x == 100) {
					System.out.println(loc[1]+1);
					break loop;
				}
				if(visited[x])continue;
				visited[x] = true;
				for (int i = 0 ; i < N ; i++) {
					if(up[i][0] == x) {
						x = up[i][1];
						if(x == 100) {
							System.out.println(loc[1]+1);
							break loop;
						}
						visited[x] = true;
						que.add(new int[] {x,loc[1]+1});
						continue loop2;
					}
				}
				for (int i = 0 ; i < M ; i++) {
					if(down[i][0] == x) {
						x = down[i][1];
						visited[x] = true;
						que.add(new int[] {x,loc[1]+1});
						continue loop2;
					}
				}
				if(x < 100)que.add(new int[] {x,loc[1]+1});
			}
		}
	}

}
