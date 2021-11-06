import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_23256_성인게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		long [] one = new long[1_000_000];
		// 끝이 1x1이 아닌 경우 배열
		long [] outer = new long[1_000_000];
		
		one[0] = 3;
		outer[0] = 4;
		
		int last = 1;
		
		for (int tc = 1 ; tc <= T ; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			if (N > last) {				
				for (int i = last ; i < N ; i++) {
					one[i] = (one[i-1]*3 + outer[i-1]*1)%1_000_000_007;
					outer[i] = (one[i-1]*4 + outer[i-1]*2)%1_000_000_007;
				}
				last = N;
			} 			
			
			long ans = (one[N-1]+outer[N-1])%1_000_000_007;
			
			sb.append(ans+"\n");
			}
		System.out.println(sb);
	}
}
