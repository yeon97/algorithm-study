import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		mem: 51924KB		time: 524ms
 */

public class Main_BJ_1916_최소비용구하기 {
	
	static class Node implements Comparable<Node>{
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
	static int N;
	static ArrayList<Node> [] nodes;
	static int S, E;
	static int INF = 987654321;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		nodes = new ArrayList[N+1];
		
		for (int i = 1 ; i <= N ; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			nodes[Integer.parseInt(st.nextToken())].add(
					new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
					);
		}
		
		st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra());
	}
	
	static int dijkstra() {
		int [] costs = new int[N+1];
		Arrays.fill(costs, INF);
		costs[S] = 0;
		
		boolean [] visited = new boolean[N+1];
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(S, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (visited[cur.end]) continue;
			visited[cur.end] = true;
			
			for (Node n : nodes[cur.end]) {
				if (costs[n.end] > costs[cur.end] + n.w) {
					costs[n.end] = costs[cur.end] + n.w;
					queue.add(new Node(n.end, costs[n.end]));
				}
			}
		}
		
		return costs[E];
	}
}
