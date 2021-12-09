import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	mem: 13300KB		time: 120ms
 */

public class Main_BJ_1561_놀이공원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [] time = new int[M+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1 ; i <= M ; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		if (N <= M) {
			System.out.println(N);
			return;
		}
		
		long start = 0;
		long end = 2_000_000_000L * 30;
				
		while (start<=end) {
			long mid = (start+end)/2;
			
			long cnt = M;
			for (int i = 1 ; i <= M ; i++) {
				cnt += mid / time[i];
			}
			
			if (cnt >= N) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}

		int cnt = M;
		for (int i = 1 ; i <= M ; i++) {
			cnt += (start-1) / time[i];
		}
		
		int ans = -1;
		
		for (int i = 1 ; i <= M ; i++) {
			if (start % time[i] == 0) {
				cnt++;
			}
			
			if (cnt == N) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
