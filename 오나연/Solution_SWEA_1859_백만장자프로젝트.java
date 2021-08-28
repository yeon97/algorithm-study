package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			int days = Integer.parseInt(br.readLine());
			int[] price = new int[days];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=0; i<days; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = price[days-1];
			long result = 0;
			for(int i=days-2; i>=0; i--) {
				if(price[i] < max) {
					result += max - price[i];
				} else {
					max = price[i];
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}