package jinmyeong.Aug2021.algo0829;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			char nc;
			if (c == 'c') {
				if (i < str.length()-1) {
					nc = str.charAt(i + 1);
					if (nc == '=' || nc == '-') {
						ans++;
						i++;
					}else ans++;
				}
				else ans++;
			} else if (c == 'l') {
				if (i < str.length()-1) {
					nc = str.charAt(i + 1);
					if (nc == 'j') {
						ans++;
						i++;
					}else ans++;
				}else ans++;
			} else if (c == 'n') {
				if (i < str.length()-1) {
					nc = str.charAt(i + 1);
					if (nc == 'j') {
						ans++;
						i++;
					}else ans++;
				}else ans++;
			} else if (c == 's' || c == 'z') {
				if (i < str.length()-1) {
					nc = str.charAt(i + 1);
					if (nc == '=') {
						ans++;
						i++;
					}else ans++;
				}else ans++;
			} else if (c == 'd') {
				if (i < str.length()-2) {
					nc = str.charAt(i + 1);
					if (nc == 'z' && str.charAt(i + 2) == '=') {
						ans++;
						i+=2;
						continue;
					}
				}
				if (i < str.length()-1) {
					nc = str.charAt(i + 1);
					if (nc == '-') {
						ans++;
						i++;
					} else ans++;
				}else ans++;
			} else ans++;

		}
		
		System.out.println(ans);

	}
}
