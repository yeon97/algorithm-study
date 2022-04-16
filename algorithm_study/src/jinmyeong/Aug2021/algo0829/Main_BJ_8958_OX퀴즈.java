package jinmyeong.Aug2021.algo0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int cnt = 0;
			int ans = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'X') {
					cnt = 0;
				} else {
					cnt++;
					ans+=cnt;
				}
			}
			sb.append(ans+"\n");
		}
		
		System.out.println(sb);
	}
}
