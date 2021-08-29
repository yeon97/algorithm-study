// 80점

import java.util.Arrays;
import java.util.Scanner;

public class Main_JUNGOL_1205_조커_0828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean arr[] = new boolean[1001001];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int zero = 0;
		
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			if (tmp == 0)
				zero++;
			else {
				arr[tmp] = true;
				min = Math.min(min, tmp);
				max = Math.max(max, tmp);
			}
		}
		
		
		int cnt = 0;
		int res = 0;
		int t = 0;
		int zeroTmp = zero;
		for (int i = min; i <= max+zero+1; i++) {
			if(arr[i]) {
				cnt++;
				if(zeroTmp > 0 && !arr[i+1]) {
					zeroTmp--;
					arr[i+1] = true;
					t = i;
				}
			}
			else {
				res = Math.max(res, cnt);
				zeroTmp = zero;
				cnt = 0;
			}
		}
		if(res == 0) {
			System.out.println(N);
		}
		else {
			System.out.println(res);
			
		}
	}
}
