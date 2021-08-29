package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		int N = str.length();
		
		int R = 1;
		int C = N;
		for(int i = 1 ; i <= N ; i++) {
			
			if(N%i == 0) {
				int r = i;
				int c = N/r;
				if (r <= c) {
					R = r;
					C = c;
				} else {
					break;
				}
			}
		}
		int idx = 0;
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C; j++) {
				sb.append(str.charAt(idx));
				idx+=R;
			}
			idx = i+1;
		}
		
		System.out.println(sb);
	}
}
