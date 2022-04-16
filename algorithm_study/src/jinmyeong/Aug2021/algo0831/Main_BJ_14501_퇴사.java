package jinmyeong.Aug2021.algo0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14501_퇴사 {
	static class Work {
		int day, pay;

		public Work(int day, int pay) {
			super();
			this.day = day;
			this.pay = pay;
		}
		
	}
	
	static int N ,ans;
	static Work [] works;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		works = new Work[N];
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			works[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		ans = 0;
		service(0, 0);
		
		System.out.println(ans);
	}
	
	static void service(int cnt, int sum) {
		if (sum > ans) {
			ans = sum;
		}
		
		for (int i = cnt ; i < N ; i++) {
			if (i + works[i].day > N) continue;
			service(i+works[i].day, sum+works[i].pay);
		}
	}
}
