package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  메모리 : 11524 KB
  시간 : 84 ms 
*/
public class Main_BOJ_11727_2xn타일링2_1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] D = new int[1001];
		D[1] = 1;
		D[2] = 3;
		
		for(int i=3; i<=n; i++) {
			D[i] = (D[i-1] + (D[i-2] * 2)) % 10007;
		}
		System.out.println(D[n]);
	}
}