import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int ans = 0;
		for (int i = 1 ; i <= n ; i++) {
			for (int j = i ; j <= n ; j++) {
				if (i*j > n) break;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
