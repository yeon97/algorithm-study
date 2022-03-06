package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 12844 KB 
  시간 : 112 ms
*/
public class Main_BOJ_1561_놀이공원_1203 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Integer.parseInt(st.nextToken());  // 아이들 수
		int M = Integer.parseInt(st.nextToken());  // 놀이기구 수
		
		int[] rides = new int[M];  // 각 놀이기구 별 운행 시간
		
		st = new StringTokenizer(br.readLine());
		
		int max = 0;  // 가장 오래 걸리는 운행 시간
		
		for(int i=0; i<M; i++) {
			rides[i] = Integer.parseInt(st.nextToken());
			if(max < rides[i]) max = rides[i];
		}
		
		if(N<=M) {
			System.out.println(N);  // 아이들 수가 놀이기구 수 보다 작으면 모든 아이들이 바로 다 탈 수 있음
		} else {
			long time = binarySearch(rides, N, M, max);  // 현재 아이들이 모두 타기 위한 시간
			long cnt = M;
			
			for(int i=0; i<M; i++) {
				cnt += (time - 1) / rides[i];
			}
			for(int i=0; i<M; i++) {
				if(time % rides[i] == 0) cnt++;	
				if(cnt == N) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
	
	private static long binarySearch(int[] rides, long N, int M, int max) {  // 모든 아이들이 놀이기구를 타기 위한 시간
		long left = 0;
		long right = (N / M) * max;  // 최대 걸리는 시간 : (아이들 수 / 놀이기구 수) * 최대 시간
		long time = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long cnt = M;
			
			for(int i=0; i<M; i++) cnt += mid / rides[i];
			
			if(N <= cnt) {
				time = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return time;
	}
}