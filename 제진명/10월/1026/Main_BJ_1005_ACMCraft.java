import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 		메모리 : 245832KB		시간 : 936ms
 */

public class Main_BJ_1005_ACMCraft {
	static int N, K, W;
	static int [] times;
	static List<Integer> [] nodes;
	static int [] sub;
	static int [] cost;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			times = new int[N+1];
			nodes = new List[N+1];
			sub = new int [N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1 ; i <= N ; i++) {
				times[i] = Integer.parseInt(st.nextToken());
				nodes[i] = new ArrayList<>();
			}
			
			
			
			for (int i = 1 ; i <= K ; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				nodes[start].add(end);
				sub[end]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			cost = new int[N+1];
			bfs();
			
			sb.append(cost[W]+"\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1 ; i <= N ; i++) {
			if (sub[i] == 0) {
				cost[i] = times[i];
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 0 ; i < nodes[cur].size(); i++) {
				int next = nodes[cur].get(i);
				cost[next] = Math.max(cost[cur] + times[next], cost[next]);
				sub[next]--;
				if (sub[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}
	
}
