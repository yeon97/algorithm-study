package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 18200KB
  시간 : 2260ms
*/

public class Main_BOJ_1238_파티_Floyd_Warshall_0928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(map[start][end] == 0) {
				map[start][end] = Integer.parseInt(st.nextToken());				
			}
		} // 입력 받아오기
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i!=j && map[i][j] == 0) map[i][j] = 100000;
			}
		} // 직접 갈 수 없는 길일 때
		
		for(int k=1; k<=N; k++) { // 경유지
			for(int i=1; i<=N; i++) {  // 출발지
				if(k==i) continue;
				for(int j=1; j<=N; j++) {  // 목적지
					if(k==j || i==j) continue;
					map[i][j] = (map[i][k] + map[k][j] < map[i][j]) ? map[i][k] + map[k][j] : map[i][j];
				}
			}
		}
		
		int[] time = new int[N+1]; // 각자 x까지 갔다가 오는데 걸리는 시간
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(i==X) continue;  // x는 고려할 필요x
			time[i] = map[i][X] + map[X][i];
			max = (max<time[i])? time[i] : max;
		}
		System.out.println(max);
	}
}