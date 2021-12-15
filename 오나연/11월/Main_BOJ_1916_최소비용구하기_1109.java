package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
  메모리 : 48660 KB
  시간 : 484 ms
*/
public class Main_BOJ_1916_최소비용구하기_1109 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		int[] dist = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			dist[i] = 100000000;
			for(int j=1; j<=N; j++) {
				map[i][j] = 100000000;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(map[from][to] > cost) map[from][to] = cost;
		}
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		dist[A] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(A, dist[A]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curI = cur.idx;
			int curC = cur.cost;
			
			if(curC > dist[curI]) continue;
			for(int i=1; i<=N; i++) {
				if(map[curI][i] == 100000000) continue;
				if(dist[i] > dist[curI] + map[curI][i]) {
					dist[i] = dist[curI] + map[curI][i];
					pq.offer(new Node(i, dist[i]));
				}
			}
		}
		System.out.println(dist[B]);
	}
	
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}