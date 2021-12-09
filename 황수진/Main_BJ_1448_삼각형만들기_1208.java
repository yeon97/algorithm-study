package month12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 메모리 : 84296KB
 시  간 : 792ms
 */

public class Main_BJ_1448_삼각형만들기_1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int [N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int res = -1;
		for (int i = N-1; i >= 2; i--) {
			if(arr[i] < arr[i-1] + arr[i-2]) {
				res = arr[i] + arr[i-1] + arr[i-2];
				break;
			}
		}
		
		System.out.println(res);
		
	}
}
