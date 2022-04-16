import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		mem : 69928KB		time : 644ms
 */

public class Main_BJ_1504_특정한최단경로 {
	static class Node implements Comparable<Node>{
		int end, w;

		public Node(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}

		@Override
		public String toString() {
			return "node [end=" + end + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int N, E;
	static ArrayList<Node>[] nodes;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 정해진 정점은 반드시 지니야하며, 지났던 점을 다시 지나갈 수 있음
		// 방향성이 없는 그래프
		
		// 1 - 1번 정점에서 한 점으로 가는 최소 경로
		// 2 - 1번 정점에서 또 다른 점으로 가는 최소 경로
		// 3 - 반드시 지나야하는 두 정점 간의 최소 경로
		// 4 - 두 정점 중 한 점에서 N번 정점으로 가는 최소 경로
		// 5 - 또 다른 정점에서 N번 정점으로 가는 최소 경로
		// ans = (1,3,4) (1,3,5), (2,3,4), (2,3,5) 중 하나
		// 답이 없으면 -1 출력
		
		nodes = new ArrayList[N+1];
		
		for (int i = 1 ; i <= N ; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodes[s].add(new Node(e, w));
			nodes[e].add(new Node(s, w));
		}
		
//		for (int i = 1 ; i <= N ; i++) {
//			System.out.print("index "+i+" : ");
//			for (int n = 0 ; n < nodes[i].size() ; n++) {
//				System.out.print(nodes[i].get(n));
//			}
//			System.out.println();
//		}
		
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int [] first = dijstra(1, new int [] {v1, v2});
		int [] middle = dijstra(v1, new int [] {v2, N});
		int [] end = dijstra(v2, new int [] {N});
		
		int res1 = first[0] + middle[0] + end[0];
		int res2 = first[1] + middle[0] + middle[1];
		
		if (res1 >= INF || res1 <= 0) res1 = INF;
		if (res2 >= INF || res2 <= 0) res2 = INF;
		
		int ans = res1>res2?res2:res1;
		
		if (ans==INF) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	
	static int [] dijstra(int start, int [] end) {
		
		int [] distance = new int [N+1];
		
		Arrays.fill(distance, INF);
		
		distance[start] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		boolean [] visited = new boolean[N+1];
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (visited[cur.end]) continue;
			visited[cur.end] = true;
			
			for (Node n : nodes[cur.end]) {
				if (distance[n.end] > distance[cur.end] + n.w) {
					distance[n.end] = distance[cur.end]+n.w;
					queue.offer(new Node(n.end, distance[n.end]));
				}
			}
		}
		
		int [] res = new int[end.length];
		
		for (int i = 0 ; i < end.length ; i++) {
			res[i] = distance[end[i]];
		}
		
//		System.out.println("start:"+start+", "+Arrays.toString(res));
		
		return res;
	}
}
