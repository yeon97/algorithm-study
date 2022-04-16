import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		mem : 59436KB		time : 456ms
 */

public class Main_BJ_9370_미확인도착지 {
	
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
	
	static ArrayList<Node> [] nodes;	// 정상 경로
	static int n, s;
	static int INF = 100_000_000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			int m, t;
			int g, h;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			nodes = new ArrayList[n+1];
			
			for (int i = 1 ; i <= n ; i++) {
				nodes[i] = new ArrayList<>();
			}
			
			for (int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				int frt = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int wei = Integer.parseInt(st.nextToken());
				
				if ((frt == g && end == h) || (end == g && frt == h)) {
					wei = wei*2-1;
				} else {
					wei *= 2;
				}
				
				nodes[frt].add(new Node(end, wei));
				nodes[end].add(new Node(frt, wei));
			}
						
			int [] dest = new int[t];
			
			for (int i = 0 ; i < t ; i++) {
				dest[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(dest);
						
			int [] res = djikstra();
			
			for (int i : dest) {
				if (res[i]%2 == 1) {
					sb.append(i+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int [] djikstra() {
		int []  distance = new int [n+1];
		Arrays.fill(distance, INF);
		distance[s] = 0;
		
		boolean [] visited = new boolean [n+1];
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node (s, 0));
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (visited[cur.end]) continue;
			visited[cur.end] = true;
			
			for (Node n : nodes[cur.end]) {
				if (distance[n.end] > distance[cur.end] + n.w) {
					distance[n.end] = distance[cur.end] + n.w;
					queue.offer(new Node(n.end, distance[n.end]));
				}
			}
		}
		
		return distance;
	}
}
