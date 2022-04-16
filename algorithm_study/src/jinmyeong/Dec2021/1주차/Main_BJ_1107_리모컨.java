import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	2021. 12. 3
 * 	mem: 69124KB	time: 300ms
 */

public class Main_BJ_1107_리모컨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean [] err = new boolean[10];
		if (M != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				err[Integer.parseInt(st.nextToken())] = true;
			}
		}
		int ans = Math.abs(N - 100);
		
		loop: for (int i = 0; i <= 1_000_000 ; i++) {
			String temp = String.valueOf(i);
			for (int j = 0 ; j < temp.length() ; j++) {
				if (err[temp.charAt(j) - '0']){
					continue loop;
				}
			}
			ans = Math.min(ans, Math.abs(N - i) + temp.length());
		}
		
		System.out.println(ans);
	}
}
