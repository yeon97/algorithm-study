package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
  메모리 : 13388 KB
  시간 :  124 ms
*/
public class Main_BOJ_2610_회의준비_1212 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) continue;
				arr[i][j] = 100000;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		// 플로이드-와샬
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				if(k==i) continue;
				for(int j=1; j<=N; j++) {
					if(k==j || i==j) continue;
					if(arr[i][j] > arr[i][k] + arr[k][j]) arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		List<Integer> represent = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			// 팀 나누기
			List<Integer> person = new ArrayList<>();
			if(!visited[i]) {
				for(int j=1; j<=N; j++) {
					if(!visited[j] && arr[i][j] != 100000) {
						person.add(j);
						visited[j] = true;
					}
				}
				int size = person.size();
				int speaker = person.get(0);
				int speaker_dist = 100000;
				
				// 대표자 뽑기
				for(int j=0; j<size; j++) {
					int curr = person.get(j);
					int max_dist = 0;
					for(int k=0; k<size; k++) {
						int tmp = person.get(k);
						if(curr==tmp) continue;
						if(max_dist < arr[curr][tmp]) max_dist = arr[curr][tmp];
					}
					if(max_dist < speaker_dist) {
						speaker = curr;
						speaker_dist = max_dist;
					}
				}
				represent.add(speaker);
			}
		}
		// 정렬
		Collections.sort(represent);
		
		int total = represent.size();
		System.out.println(total);
		for(int i=0; i<total; i++) {
			System.out.println(represent.get(i));
		}
	}
}