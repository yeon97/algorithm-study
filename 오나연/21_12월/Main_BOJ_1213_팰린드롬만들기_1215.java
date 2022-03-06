package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  메모리 : 11484 KB
  시간 : 76 ms 
*/
public class Main_BOJ_1213_팰린드롬만들기_1215 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] name = br.readLine().toCharArray();
		int[] alphabet = new int[26];
		int length = name.length;
		
		for(int i=0; i<length; i++) {
			int num = name[i] - 65;
			alphabet[num]++;
		}
		
		int odd = 0;
		int alpha = -1;
		for(int i=0; i<26; i++) {
			if(alphabet[i] % 2 == 1) {
				alpha = i;
				odd++;
			}
			if(odd > 1) break;
		}
		
		if(odd > 1) {
			sb.append("I'm Sorry Hansoo");
		} else {
			int idx = 0;
			for(int i=0; i<26; i++) {
				if(alphabet[i] == 0) continue;
				if(alpha == i) alphabet[i]--;
				for(int j=0; j<alphabet[i]; j++) {
					sb.insert(idx, (char)(i+65));					
				}
				idx += alphabet[i]/2;
			}
			if(odd == 1) sb.insert(idx, (char)(alpha+65));
		}
		System.out.println(sb);
	}
}