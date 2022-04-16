package jinmyeong.Aug2021.algo0827;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자프로젝트 {
	static int N;
	static int[] prices;
	static int max, maxIdx;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1 ; tc<=T ; tc++) {
			long ans = 0;
			
			N = Integer.parseInt(br.readLine());
			prices = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0 ; i < N ; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			while(true) {
				if(idx >= N) {
					break;
				}
				
				findMax(idx);
				
				for(int i = idx ; i < maxIdx ; i++) {
					ans += max-prices[i];
				}
				idx = maxIdx+1;
				max = 0;
			}
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	static void findMax(int start) {
		for (int i = start; i < N; i++) {
			int temp = prices[i];
			if (temp > max) {
				max = temp;
				maxIdx = i;
			}
		}
	}
}
