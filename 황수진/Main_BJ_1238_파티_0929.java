import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_BJ_1238_파티_0929 {
	private static class Node implements Comparable<Node> {
		int des; 
		int t;

		public Node(int des, int t) {
			super();
			this.des = des;
			this.t = t;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.t, o.t);
		}

	}
	
	static int N, M, X;
	static ArrayList<Node> startX[], endX[];
	static int[] start, end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		X = Integer.parseInt(st.nextToken()); // 시작 점

		startX = new ArrayList[N + 1];
		endX = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			startX[i] = new ArrayList<>();
			endX[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			startX[r].add(new Node(c, t));
			endX[c].add(new Node(r, t));

		}
		
		int start[] = dijkstra(startX);
		int end[] = dijkstra(endX);
//		System.out.println(Arrays.toString(start));
//		System.out.println(Arrays.toString(end));
		
		int res = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			res = Math.max(res, start[i] + end[i]);
		}
		System.out.println(res);
	}

	private static int[] dijkstra(ArrayList<Node> arr[]) {
		boolean checked[] = new boolean[N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		
		int d[] = new int[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[X] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int cur = node.des;
			
			if(checked[cur]) continue;
			checked[cur] = true;
			
			for(Node next : arr[cur]) {
				if(d[next.des] > d[cur] + next.t) {
					d[next.des] = d[cur] + next.t;
					pq.add(new Node(next.des, d[next.des]));
				}
			}
			
		}
		return d;
	}

}
