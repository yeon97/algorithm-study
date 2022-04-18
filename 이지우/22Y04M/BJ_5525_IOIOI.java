package M01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5525_IOIOI {
	static int[] list;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		list = new int[M];
		for(int i = 0 ; i < M; i ++) {
			list[i] = str.charAt(i)-'I';
		}
		
		int cnt = 0;
		int startIndex = findStartIndex(0);
		int ans = 0;
		for(int i = startIndex; i < M-2; i++) {
			if(list[i] + list[i+2] == 0 && list[i+1] == 6) {
				cnt++;
				i++;
			}else {
				cnt = 0;
			}
			
			if(cnt >= N) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static int findStartIndex(int startIndex) {
		
		for(int i = startIndex ; i < M; i++) {
			if(list[i] == 0) {
				startIndex = i;
				break;
			}
		}
		return startIndex;
	}

}
