package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		메모리 : 16528KB		시간 : 160ms
 */

public class Main_BJ_1238_파티 {
	static class Node implements Comparable<Node> {
		int end, w;

		public Node(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static int N, M, X;
	static ArrayList<Node> [] nodes;
	static ArrayList<Node> [] nodes2;
	static int [] dist;
	static int [] dist2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int INF = 100_000_000;
		
		
		
		N = Integer.parseInt(st.nextToken());	// 사람수
		M = Integer.parseInt(st.nextToken());	// 간선수
		X = Integer.parseInt(st.nextToken());	// 도착 할 마을 번호
		
		nodes = new ArrayList[N+1];
		nodes2 = new ArrayList[N+1];
		dist = new int[N+1];
		dist2 = new int[N+1];
		
		for (int i = 1 ; i <= N ; i++) {
			nodes[i] = new ArrayList<>();
			nodes2[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			nodes[end].add(new Node(start, T));
			nodes2[start].add(new Node(end, T));
		}
		
		Arrays.fill(dist, INF);
		dijkstra(X);
		Arrays.fill(dist2, INF);
		dijkstra2(X);
		
		int res = 0;
		for (int i = 1 ; i <= N ; i++) {
			if (res < dist[i]+dist2[i]) res = dist[i]+dist2[i];
		}
		
		System.out.println(res);
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean [] visited = new boolean[N+1];
		
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int cur = now.end;
			
			if (visited[cur]) continue;
			visited[cur] = true;
			
			for (Node node : nodes[cur]) {
				if(dist[node.end] > dist[cur] + node.w) {
					dist[node.end] = dist[cur] + node.w;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
			
		}
		
	}
	static void dijkstra2(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean [] visited = new boolean[N+1];
		
		queue.add(new Node(start, 0));
		dist2[start] = 0;
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int cur = now.end;
			
			if (visited[cur]) continue;
			visited[cur] = true;
			
			for (Node node : nodes2[cur]) {
				if(dist2[node.end] > dist2[cur] + node.w) {
					dist2[node.end] = dist2[cur] + node.w;
					queue.add(new Node(node.end, dist2[node.end]));
				}
			}
			
		}
		
	}
}
