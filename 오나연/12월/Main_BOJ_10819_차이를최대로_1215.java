package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 12384 KB
  시간 : 112 ms
*/
public class Main_BOJ_10819_차이를최대로_1215 {
	static int total;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] make = new int[N];
		boolean[] visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		perm(num, make, visited, 0, N);
		System.out.println(total);
	}
	
	static void perm(int[] num, int[] make, boolean[] visited, int cnt, int N) {
		if(cnt == N) {
			int sum = 0;
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(make[i] - make[i+1]);
			}
			if(sum > total) total = sum;
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			make[cnt] = num[i];
			visited[i] = true;
			perm(num, make, visited, cnt+1, N);
			visited[i] = false;
		}
	}
}