package M01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1027_고층건물 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] buildings  = new int[N];
		for(int i = 0 ; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		//모든 건물 기준으로 확인한다.
		for(int i = 0; i < N; i++) {
			//좌 우로 나눠서 확인한다.
			int tmp = 0;
			tmp += canSeeLeft(i, buildings);
			tmp += canSeeRight(i, buildings);
			max = Math.max(max, tmp);
			//가장 큰것을 구한다.
		}
		
		System.out.println(max);
		
	}

	private static int canSeeRight(int i, int[] buildings) {
		//기울기를 비교해야한다. 좌측이라면 점점 작아야하고 우측이라면 점점 커야할것이다
		if(i+1 >= N) return 0;
		long inclinationY;
		long inclinationX = 1;
		int cnt = 1;
		inclinationY = buildings[i+1] - buildings[i];
		
		int loc = i+1;
		while(++loc < N) {
			long y = buildings[loc] - buildings[i];
			long x = loc - i;
			if(x*inclinationY < y*inclinationX) { //기존꺼보다 기울기가 크면
				cnt++;
				inclinationX = x;
				inclinationY = y;
			}
		}
		
		//끝까지 다 확인해봐야한다.
		return cnt;
	}

	private static int canSeeLeft(int i, int[] buildings) {
		//기울기를 비교해야한다. 좌측이라면 점점 작아야하고 우측이라면 점점 커야할것이다
		if(i <= 0) return 0;
		long inclinationY;
		long inclinationX = -1;
		int cnt = 1;
		inclinationY = buildings[i-1] - buildings[i];
		
		int loc = i-1;
		while(--loc >= 0) {
			long y = buildings[loc] - buildings[i];
			long x = loc - i;
			if(x*inclinationY > y*inclinationX) { //기존꺼보다 기울기가 작으면
				cnt++;
				inclinationX = x;
				inclinationY = y;
			}
		}
		
		//끝까지 다 확인해봐야한다.
		return cnt;
	}
}
