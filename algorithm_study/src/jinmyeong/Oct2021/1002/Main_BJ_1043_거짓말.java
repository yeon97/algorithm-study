package algo_work1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 	메모리 11744KB		시간 88ms
 */

public class Main_BJ_1043_거짓말 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int tNum = Integer.parseInt(st.nextToken());
		int [] tPs = new int[tNum];
		
		for (int i = 0 ; i < tNum ; i++) {
			tPs[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> [] pPs = new ArrayList[M+1];	// i파티에 참여하고 있는 사람들
		ArrayList<Integer> [] jPs = new ArrayList[N+1];	// i사람이 참여하고 있는 파티들
		
		for (int i = 1 ; i <= N ; i++) {
			jPs[i] = new ArrayList<>();
		}
		
		for (int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			pPs[i] = new ArrayList<>();
			int end = Integer.parseInt(st.nextToken());
			for (int j = 0 ; j < end; j++) {
				int p = Integer.parseInt(st.nextToken());
				pPs[i].add(p);
				jPs[p].add(i);
			}
		}
		
		boolean [] visited = new boolean[M+1];	// 파티 방문 여부
		boolean [] pVisited = new boolean[N+1];	// 사람 방문 여부
		
		Queue<Integer> queue = new LinkedList<>();	// 진실을 말해야하는 사람들이 담긴 큐
		
		for (int i = 0 ; i < tNum ; i++) {
			queue.add(tPs[i]);
		}
		
		if (queue.isEmpty()) {
			System.out.println(M);
			return;
		}
		
		while(!queue.isEmpty()) {
			int p = queue.poll();	// 진실을 알고 있는 사람
			Queue<Integer> pQueue = new LinkedList<>();	// 진실을 말해야 하는 파티 큐
			// 사람 p가 참여하고 있는 파티를 돌면서 찾음
			for (int i = 0 ; i < jPs[p].size() ; i++) {
				// jPs[p].get(i) => 사람 p가 참여하고 있는 파티
				if (visited[jPs[p].get(i)]) continue;
				
				pQueue.add(jPs[p].get(i));	// 진실을 말해야하는 파티를 큐에 추가
				visited[jPs[p].get(i)] = true;	// 진실을 말한 파티 방문 체크
			}
			
			while(!pQueue.isEmpty()) {
				int party = pQueue.poll(); // 진신을 말해야하는 파티
				// 해당 파티에 참여하고 있는 사람을 찾음
				for (int i = 0 ; i < pPs[party].size() ; i++) {
					if (pVisited[pPs[party].get(i)]) continue;
					
					queue.add(pPs[party].get(i));
					pVisited[pPs[party].get(i)] = true;
				}
			}
		}
		
		int ans = 0;
		for (int i = 1 ; i < M+1 ; i++) {
			if (!visited[i]) ans++;
		}
		
		System.out.println(ans);
	}
}
