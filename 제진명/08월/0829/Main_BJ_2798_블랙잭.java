import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2798_블랙잭 {
	static int N, M;
	static int R = 3;
	static int [] nums;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0,0);
		
		System.out.println(ans);
		
	}
	
	static void comb(int cnt, int idx, int sum) {
		if (sum > M) {
			return;
		}
		if (cnt == R) {
			if (sum > ans) ans = sum;
			return;
		}
		
		for (int i = idx ; i < N ; i++) {
			comb(cnt+1, i+1, sum+nums[i]);
		}
	}
}
