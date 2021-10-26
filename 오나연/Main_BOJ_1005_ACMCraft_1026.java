package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 메모리 : 240412 KB
 시간 : 772 ms
*/

public class Main_BOJ_1005_ACMCraft_1026 {
	static int[] D, time;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			time = new int[N+1];
			D = new int[N+1];
			ArrayList<Integer>[] parents = new ArrayList[N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				time[i] = tmp;
				D[i] = tmp;
				parents[i] = new ArrayList<>();
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				parents[end].add(start);
			}
			
			for(int i=1; i<=N; i++) {
				find(i, parents);
			}
			
			int W = Integer.parseInt(br.readLine());
			System.out.println(D[W]);
		}
	}
	
	private static void find(int i, ArrayList<Integer>[] parents) {
		if(parents[i].isEmpty() && D[i]<time[i]) D[i] = time[i];
		else {
			while(!parents[i].isEmpty()) {
				int start = parents[i].remove(0);
				if(!parents[start].isEmpty()) find(start, parents);
				if(D[start] + time[i] > D[i]) D[i] = D[start] + time[i]; 
			}
		}
	}
}