package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
  메모리 : 47856 KB
  시간 : 696 ms 
*/
public class Main_BOJ_2252_줄세우기_1207 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[N+1];
		ArrayList<ArrayList<Integer>> h = new ArrayList<>();
		
		for(int i=0; i<=N; i++) h.add(new ArrayList<Integer>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			h.get(front).add(back);
			cnt[back]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(cnt[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			ArrayList<Integer> curStudent = h.get(cur);
			
			for(int i=0; i<curStudent.size(); i++) {
				int next = curStudent.get(i);
				cnt[next]--;
				if(cnt[next] == 0) q.offer(next);
			}
		}
	}
}