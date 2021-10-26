package zm10d19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_12851_숨바꼭질2 {
	static int cnt, min = Integer.MAX_VALUE, K, N;
	static int[] time  = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if(N >= K) {
			System.out.println((N-K) + "\n1");
		}else {
			bfs(N);
			System.out.print(min + "\n" + cnt);
		}
	}
	private static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		time[N] = 1;
		while(!que.isEmpty()) {
			int now = que.poll();
			if(time[now] > min) break;
			for(int i = 0 ; i < 3; i++) {
				int next;
				if(i == 0) {
					next = now +1;
				}else if( i == 1) {
					next = now -1;
				}else {
					next = now*2;
				}
				if(next < 0 || next > 100000) continue;
				if(next == K) {
					min = time[now];
					cnt++;
				}
				if(time[next] == 0 || time[next] == time[now]+1) {
					que.add(next);
					time[next] = time[now] + 1;
				}
			}
		}
		
	}

}
