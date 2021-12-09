import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
 * 	2021. 12. 8
 * 	mem: 107112KB	time: 2288ms
 */

public class Main_BJ_1448_삼각형만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer [] straws = new Integer[N];
		
		for (int i = 0 ; i < N ; i++) {
			straws[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(straws, Collections.reverseOrder());
		
//		System.out.println(Arrays.toString(straws));
		
		int ans = -1;
		
		for (int i = 0 ; i < N-2 ; i++) {
			if (straws[i] < straws[i+1] + straws[i+2]) {
				ans = straws[i]+straws[i+1]+straws[i+2];
				break;
			}
		}
		
		System.out.println(ans);
	}
}
