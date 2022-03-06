package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 메모리 : 80604 KB
 시간 : 688 ms
*/

public class Main_BOJ_1448_삼각형만들기_1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] straw = new int[N];
		for(int i=0; i<N; i++) straw[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(straw);
		
		for(int i=N-1; i>=2; i--) {
			if(straw[i] < straw[i-1] + straw[i-2]) {
				System.out.println(straw[i] + straw[i-1] + straw[i-2]);				
				return;
			}
		}
		System.out.println(-1);
	}
}