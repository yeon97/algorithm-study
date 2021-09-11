package om8d31;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14501_퇴사 {
	static int Max, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] dam = new int[N][2];
		for(int i = 0 ; i < N; i++){
			dam[i][0] = sc.nextInt();
			dam[i][1] = sc.nextInt();
		}
		persi(0,dam, new boolean[N]);
		System.out.println(Max);
	}
	public static void persi(int r, int[][] dam, boolean[] visited){
		if(r >= N){
			
			int num = 0 ;
			for(int i = 0 ; i < N ; i++){
				if(visited[i] && dam[i][0]+i <= N){
					
					num+=dam[i][1];
				}
			}
			Max = Math.max(num, Max);
			return;
		}
		
		int delay = dam[r][0];
		visited[r] = true;
		persi(r+delay, dam, visited);
		
		visited[r] = false;
		persi(r+1, dam, visited);
	}
}
