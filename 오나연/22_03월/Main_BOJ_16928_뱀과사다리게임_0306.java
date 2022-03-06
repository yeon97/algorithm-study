package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16928_뱀과사다리게임_0306 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int total = N + M;
		
		Map<Integer, Integer> move = new HashMap<>();
		boolean[] visited = new boolean[101];
		
		for(int i=0; i<total; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			move.put(from, to);
		}
		
		Queue<Pos> q = new LinkedList<>();
		int answer = 10000;
		
		q.offer(new Pos(1,0));
		visited[1] = true;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int curL = cur.loc;
			int curC = cur.cnt;
			
			if(curL == 100 && curC < answer) answer = curC;
			
			for(int i=1; i<=6; i++) {
				int tmp = curL + i;
				
				if(tmp > 100 || visited[tmp]) continue;
				visited[tmp] = true;
				
				if(move.containsKey(tmp)) q.offer(new Pos(move.get(tmp), curC+1));
				else q.offer(new Pos(tmp, curC+1));
			}
		}
		System.out.println(answer);
	}
	
	static class Pos{
		int loc, cnt;
		public Pos(int loc, int cnt) {
			this.loc = loc;
			this.cnt = cnt;
		}
	}
}