import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 	2021. 12. 05
 * 	mem: 53444KB		time: 508ms
 */


public class Main_BJ_2252_줄세우기 {
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [] cnt = new int[N+1];
		List<Integer> [] list = new ArrayList [N+1];
		
		for (int i = 1 ; i <= N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int frt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[frt].add(end);
			cnt[end]++;
		}
		
		Queue<Integer> res = sort(cnt, list);
		
		for (Integer i : res) {
			sb.append(i+" ");
		}
		
		System.out.println(sb);
	}
	
	static Queue<Integer> sort(int[] cnt, List<Integer> [] list) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		
		// 자식이 없는 노드를 먼저 담는다
		for (int i = 1 ; i <= N ; i++) {
			if(cnt[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			result.offer(node);
			
			for (Integer i : list[node]) {
				cnt[i]--;
				
				if (cnt[i] == 0) {
					queue.offer(i);
				}
			}
		}
		
		return result;
	}
}
