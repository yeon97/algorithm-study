package jinmyeong.Aug2021.algo0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] times = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		
		int ans = 0;
		
		for (int i = 0 ; i < N ; i++) {
			int temp = 0;
			for (int j = i ; j < N ; j++) {
				temp += times[i];
			}
			ans += temp;
		}
		
		System.out.println(ans);
	}
}
